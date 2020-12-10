package com.ps.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ps.user.service.IUserService;
import com.ps.user.service.UserServiceImpl;

@Configuration
public class ServiceConfig {
	
	@Bean
	public IUserService userService(){
		  return new UserServiceImpl(); 
	  }

}
