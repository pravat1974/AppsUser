package com.ps.user.exception;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.sql.SQLException;

import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;


public class APPSDataAccessException extends GlobalException{
	
	public APPSDataAccessException(HttpStatus status, String message, Throwable e) {
		super(status, message, e);
		// TODO Auto-generated constructor stub
	}
	private Throwable th;
	private String message;
	private String errorCode;

	
	
	
}