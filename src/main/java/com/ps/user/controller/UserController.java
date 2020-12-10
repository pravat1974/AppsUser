package com.ps.user.controller;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.user.dtos.UserDTO;
import com.ps.user.model.APPUser;

import com.ps.user.service.IUserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/users/")
public class UserController {

	// @Autowired
	private IUserService userService;

	public UserController(IUserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<APPUser> createUser(@RequestBody UserDTO userDto) {
		APPUser user = new APPUser();

		BeanUtils.copyProperties(userDto, user, "ID");

		System.out.println("User is " + user);

		user.setCreatedTime(LocalDateTime.now());
		user.setLastUpdatedTime(LocalDateTime.now());

		return userService.createUser(user);

	}

	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<APPUser> updateUser(@RequestBody UserDTO userDto) {
		APPUser user = new APPUser();

		BeanUtils.copyProperties(userDto, user);

		return userService.updateUser(user);

	}

	@PutMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Void> deleteUser(@PathVariable Integer id) {
	
		return userService.deleteUser(id);

	}

	@GetMapping(value = "/findAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<UserDTO> findAllUser() {
		   	Flux<UserDTO> appUser = userService.geAllUser()
				.map(new Function<APPUser, UserDTO>() {
						public UserDTO apply(APPUser user) {
							UserDTO dto = new UserDTO();
							BeanUtils.copyProperties(user, dto);
							return dto;
			}
		});
  
		return appUser;

	}

}
