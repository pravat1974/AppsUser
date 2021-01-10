package com.ps.user.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.ps.user.dtos.UserDTO;
import com.ps.user.model.APPUser;
import com.ps.user.service.UserService;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@WebFluxTest(UserController.class)
@Log4j2
public class UserControllerTest {

	@Autowired
	private WebTestClient webTestClient;
	@MockBean
	private UserService userService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testUserController() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateUser() {
		APPUser user = new APPUser();
		user.setUserName("Pravat");
		user.setUserType("ADMIN");
		user.setCreatedBy("Pravat");
		user.setCreatedTime(LocalDateTime.now());
		user.setCurrentStatus("Notactive");
		user.setEmail("pravat.sahoo@hotmail.com");
		user.setPassword("password123");
		user.setId(1);
		Mono<APPUser> monoUser = Mono.just(user);
		when(userService.createUser(user)).thenReturn(monoUser);
		UserDTO userDto = new UserDTO();
		BeanUtils.copyProperties(user, userDto, "ID");
		webTestClient.post().uri("/api/users/create").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(userDto), UserDTO.class).exchange().expectStatus().isCreated();
	}

	@Test
	void testUpdateUser() {
		APPUser user = new APPUser();
		user.setUserName("Pravat");
		user.setUserType("ADMIN");
		user.setCreatedBy("Pravat");
		user.setCreatedTime(LocalDateTime.now());
		user.setCurrentStatus("Notactive");
		user.setEmail("pravat.sahoo@hotmail.com");
		user.setPassword("password123");
		user.setId(3);
		Mono<APPUser> monoUser = Mono.just(user);
		when(userService.createUser(user)).thenReturn(monoUser);
		when(userService.getUser(user.getId()))
         .thenReturn(Mono.just(user));
		UserDTO userDto = new UserDTO();
		BeanUtils.copyProperties(user, userDto, "ID");
		webTestClient.put()
		.uri("/api/users/update")
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)
		.body(Mono.just(userDto), UserDTO.class)
		.exchange().expectStatus().isOk();
	
	}

	@Test
	void testDeleteUser() {
		APPUser user = new APPUser();
		user.setUserName("Priti");
		user.setUserType("ADMIN");
		user.setCreatedBy("pravat");
		user.setCreatedTime(LocalDateTime.now());
		user.setCurrentStatus("Notactive");
		user.setEmail("priti.sahoo@hotmail.com");
		user.setPassword("PRITISA");
		user.setId(15);
		Mono<APPUser> monoUser = Mono.just(user);
		when(userService.createUser(user)).thenReturn(monoUser);
		webTestClient.delete()
		.uri("/api/users/delete/{15}")
		.exchange()
		.expectStatus().isOk();
	}

	@Test
	void testFindAllUser() {
		webTestClient.get()
		.uri("/api/users/findAll")
		.accept(MediaType.APPLICATION_JSON)
		.exchange()
		.expectStatus().isOk()
		.expectBodyList(APPUser.class)
		.value(users-> users.forEach(user->assertTrue(user.getCreatedBy().equalsIgnoreCase("pravat"))));
		
	}
	@Test
	void testFindUser() {
		
		APPUser user = new APPUser();
		user.setUserName("Priti");
		user.setUserType("ADMIN");
		user.setCreatedBy("pravat");
		user.setCreatedTime(LocalDateTime.now());
		user.setCurrentStatus("Notactive");
		user.setEmail("priti.sahoo@hotmail.com");
		user.setPassword("PRITISA");
		user.setId(12);
		Mono<APPUser> monoUser = Mono.just(user);
		when(userService.createUser(user)).thenReturn(monoUser);
		webTestClient.get()
		.uri("/api/users/user/12")
		.accept(MediaType.APPLICATION_JSON)
		.exchange()
		.expectStatus().isOk()
		.expectBody(APPUser.class)
		.value(userOne-> user.getEmail(),equalTo("priti.sahoo@hotmail.com"));
}
	

}
