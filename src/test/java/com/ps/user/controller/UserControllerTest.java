package com.ps.user.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.ps.user.dtos.UserDTO;
import com.ps.user.model.APPUser;
import com.ps.user.repo.ReactiveUserRepository;
import com.ps.user.service.UserService;

import lombok.extern.log4j.Log4j2;

import reactor.core.publisher.Mono;

@WebFluxTest(UserController.class)
@Log4j2
/*
 * @TestPropertySource(locations="classpath:application-test.properties")
 * 
 * @EnableConfigurationProperties
 * 
 * @ActiveProfiles("test")
 */
public class UserControllerTest {

	@Autowired
	private WebTestClient webTestClient;
	@MockBean
	private UserService userService;
	/*
	 * @Autowired private ReactiveUserRepository reactiveUserRepo;
	 */

	@BeforeEach

	public void cleanDB() {

		// this.reactiveUserRepo.deleteAll().block();
	}

	@Test
	void testCreateUser() {
		System.out.println("Test start");
		APPUser user = new APPUser();

		user.setCreatedBy("Pravat");
		user.setCreatedTime(LocalDateTime.now());
		user.setCurrentStatus("Notactive");
		user.setEmail("prava12t.sahoo@hotmail.com");
		user.setId(10909);
		user.setLastUpdatedBy("pravat");
		BigInteger mob = new BigInteger("9093013625");
		user.setMobile(mob);
		user.setPassword("password123");
		user.setUserName("P0ravat");
		user.setUserType("ADMIN");

		Mono<APPUser> monoUser = Mono.just(user);
		when(userService.createUser(user)).thenReturn(monoUser);
		UserDTO userDto = new UserDTO();
		BeanUtils.copyProperties(user, userDto, "ID");
		webTestClient.post().uri("/api/users/create").contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).body(Mono.just(userDto), UserDTO.class).exchange().expectStatus()
		.isCreated();
		System.out.println("Test end");
	}

	@Test
	void testUpdateUser() {
		APPUser user = new APPUser();
		user.setCreatedBy("Pravat");
		user.setCreatedTime(LocalDateTime.now());
		user.setCurrentStatus("Notactive");
		user.setEmail("pravat.sahoo@hotmail.com");
		user.setId(1);
		user.setLastUpdatedBy("pravat");
		BigInteger mob = new BigInteger("9930136257");
		user.setMobile(mob);
		user.setPassword("password123");
		user.setUserName("Pravat");
		user.setUserType("ADMIN");
		Mono<APPUser> monoUser = Mono.just(user);
		when(userService.createUser(user)).thenReturn(monoUser);
		when(userService.findById(user.getId())).thenReturn(Mono.just(user));
		UserDTO userDto = new UserDTO();
		BeanUtils.copyProperties(user, userDto, "ID");
		webTestClient.put().uri("/api/users/update").contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).body(Mono.just(userDto), UserDTO.class).exchange().expectStatus()
		.isOk();

	}

	@Test
	void testDeleteUser() {
		APPUser user = new APPUser();
		user.setCreatedBy("Pravat");
		user.setCreatedTime(LocalDateTime.now());
		user.setCurrentStatus("Notactive");
		user.setEmail("pravat.sahoo@hotmail.com");
		user.setId(1);
		user.setLastUpdatedBy("pravat");
		BigInteger mob = new BigInteger("9930136257");
		user.setMobile(mob);
		user.setPassword("password123");
		user.setUserName("Pravat");
		user.setUserType("ADMIN");
		Mono<APPUser> monoUser = Mono.just(user);
		when(userService.createUser(user)).thenReturn(monoUser);
		webTestClient.delete().uri("/api/users/delete/15").exchange().expectStatus().isOk();
	}

	@Test
	void testFindAllUser() {
		UserDTO dtoOne = new UserDTO();
		dtoOne.setId(4);
		UserDTO dtoTwo = new UserDTO();
		dtoTwo.setId(1);
		webTestClient.get().uri("/api/users/findAll").accept(MediaType.APPLICATION_JSON).exchange().expectStatus()
		.isOk().expectBody(APPUser.class);
	}

	@Test
	void testFindUser() {

		APPUser user = new APPUser();
		user.setCreatedBy("Pravat");
		user.setCreatedTime(LocalDateTime.now());
		user.setCurrentStatus("Notactive");
		user.setEmail("pravat.sahoo@hotmail.com");
		user.setId(1);
		user.setLastUpdatedBy("pravat");
		BigInteger mob = new BigInteger("9930136257");
		user.setMobile(mob);
		user.setPassword("password123");
		user.setUserName("Pravat");
		user.setUserType("ADMIN");
		Mono<APPUser> monoUser = Mono.just(user);
		when(userService.createUser(user)).thenReturn(monoUser);
		webTestClient.get().uri("/api/users/user/12").accept(MediaType.APPLICATION_JSON).exchange().expectStatus()
		.isOk().expectBody(APPUser.class).value(userOne -> user.getEmail(), equalTo("pravat.sahoo@hotmail.com"));
	}

}
