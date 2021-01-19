package com.ps.user.controller;

import java.time.LocalDateTime;
import javax.validation.Valid;
import javax.validation.Validator;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ps.user.dtos.UserDTO;
import com.ps.user.exception.GlobalException;
import com.ps.user.model.APPUser;

import com.ps.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("/api/users/")
public class UserController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private Validator validator;
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	// @ResponseStatus(HttpStatus.CREATED)
	public Mono<APPUser> createUser(@Valid @RequestBody UserDTO userDto) {
		
		if(userDto.getId()!=null) {
			return Mono.error(new GlobalException(HttpStatus.BAD_REQUEST, "Error: ID is not allowed while creating user"));
		}
	
		APPUser user = new APPUser();
		BeanUtils.copyProperties(userDto, user, "ID");
		user.setCreatedTime(LocalDateTime.now());
		user.setLastUpdatedTime(LocalDateTime.now());
		// log.info(" Data ="+user);
		Mono<APPUser> appUser = userService.createUser(user);

		return appUser;

	}

	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<APPUser> updateUser(@RequestBody @Valid UserDTO userDto) {
		APPUser user = new APPUser();
		BeanUtils.copyProperties(userDto, user);
		user.setCreatedTime(LocalDateTime.now());
		user.setLastUpdatedTime(LocalDateTime.now());
		return userService.updateUser(user);

	}

	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Mono<APPUser> deleteUser(@PathVariable("id") Integer id) {

		return userService.deleteUser(id);

	}

	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Flux<APPUser> findAllUser() {
		Flux<APPUser> appUser = userService.geAllUser();
		/*
		 * .map(new Function<APPUser, UserDTO>() { public UserDTO apply(APPUser user) {
		 * UserDTO dto = new UserDTO(); BeanUtils.copyProperties(user, dto); return dto;
		 * } });
		 */

		return appUser;

	}

	@GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<APPUser> findById(@PathVariable("id") Integer id) {

		return userService.findById(id);

	}

}
