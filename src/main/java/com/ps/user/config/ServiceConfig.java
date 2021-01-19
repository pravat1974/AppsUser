package com.ps.user.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.ps.user.service.UserService;
import com.ps.user.service.UserServiceImpl;




@Configuration
public class ServiceConfig {
	
	@Bean
	public UserService userService(){
		  return new UserServiceImpl(); 
  }
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource
	      = new ReloadableResourceBundleMessageSource();
	    
	    messageSource.setBasename("classpath:app-message");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	@Bean
	public LocalValidatorFactoryBean getValidator() {
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(messageSource());
	    return bean;
	}
	

}
