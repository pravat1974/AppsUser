package com.ps.user.service;

import java.math.BigInteger;

import java.time.LocalDateTime;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.context.annotation.Import;

import com.ps.user.config.TestPostgressDBConfig;
import com.ps.user.model.APPUser;
import com.ps.user.repo.ReactiveUserRepository;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import org.assertj.core.api.Assertions;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.StringUtils;

@DataR2dbcTest
@ActiveProfiles("test")
@Import(UserServiceImpl.class)
@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class, classes = TestPostgressDBConfig.class)
@TestPropertySource(locations="classpath:application-test.properties")
@EnableConfigurationProperties

public class UserServiceTest {


	@Autowired
	private UserService userService;
	@Autowired
	private ReactiveUserRepository reactiveUserRepo;
	 
	@BeforeEach
	
	public void cleanDB() {

		this.reactiveUserRepo.deleteAll().block();
	}
	
	@Test
	@DisplayName("DeleteUser()")
	void testDeleteUser() {
		APPUser appUser = new APPUser();
		appUser.setCreatedBy("Pravat");
		appUser.setCreatedTime(LocalDateTime.now());
		appUser.setCurrentStatus("NONACTIVE");
		appUser.setEmail("myemail@eamail.com");
		appUser.setLastUpdatedBy("Pravat");
		appUser.setLastUpdatedTime(LocalDateTime.now());
		BigInteger mob = new BigInteger("9930136257");
		appUser.setMobile(mob);
		appUser.setPassword("Nopassword");
		appUser.setUserName("Pravat19877");
		appUser.setUserType("admin");
		
		Mono<APPUser> created = this.userService.createUser(appUser)
				.flatMap(saved -> this.userService.deleteUser(saved.getId()));
		StepVerifier.create(created)
				.assertNext(result -> Assertions.assertThat(result)
						.hasFieldOrPropertyWithValue("createdBy", appUser.getCreatedBy())
						.hasFieldOrPropertyWithValue("email", appUser.getEmail())
						.hasFieldOrPropertyWithValue("userName", appUser.getUserName())
						.hasFieldOrPropertyWithValue("id", appUser.getId()))
				.verifyComplete();
	}
	
	@Test
	@DisplayName("CreateUser()")
	void testCreateUser() {

		APPUser appUser = new APPUser();

		appUser.setCreatedBy("Pravat");
		appUser.setCreatedTime(LocalDateTime.now());
		appUser.setCurrentStatus("NONACTIVE");
		appUser.setEmail("myemail@eamail.com");
		appUser.setLastUpdatedBy("Pravat");
		appUser.setLastUpdatedTime(LocalDateTime.now());
		BigInteger mob = new BigInteger("9930136257");
		appUser.setMobile(mob);
		appUser.setPassword("Nopassword");
		appUser.setUserName("Pravat19877");
		appUser.setUserType("admin");
		appUser.setId(5);
		Mono<APPUser> user = this.userService.createUser(appUser);
		StepVerifier.create(user)
				.assertNext(result -> Assertions.assertThat(result)
						.hasFieldOrPropertyWithValue("createdBy", appUser.getCreatedBy())
						.hasFieldOrPropertyWithValue("email", appUser.getEmail())
						.hasFieldOrPropertyWithValue("userName", appUser.getUserName()))
				.verifyComplete();
	}

	@Test
	@DisplayName("FindById()")
	void testFindById() {

		APPUser appUser = new APPUser();
		appUser.setCreatedBy("Pravat");
		appUser.setCreatedTime(LocalDateTime.now());
		appUser.setCurrentStatus("NONACTIVE");
		appUser.setEmail("pks@eamail.com");
		appUser.setLastUpdatedBy("Pravat");
		appUser.setLastUpdatedTime(LocalDateTime.now());
		BigInteger mob = new BigInteger("9989898171");
		appUser.setMobile(mob);
		appUser.setPassword("Nopassword");
		appUser.setUserName("Pravat90");
		appUser.setUserType("admin");

		Mono<APPUser> created = this.userService.createUser(appUser)
				.flatMap(saved -> this.userService.findById(saved.getId()));
		StepVerifier.create(created).expectNextMatches(profile -> StringUtils.hasText(profile.getEmail())
				&& appUser.getEmail().equalsIgnoreCase(profile.getEmail())).verifyComplete();

	}

}
