package com.ps.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ps.user.repo.ReactiveUserRepository;
import com.ps.user.service.UserService;
import com.ps.user.service.UserServiceImpl;

@Configuration
public class ServiceConfig {
	
	@Bean
	public UserService userService(){
		  return new UserServiceImpl(); 
  }

}
