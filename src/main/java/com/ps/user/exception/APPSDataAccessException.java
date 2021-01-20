package com.ps.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class APPSDataAccessException  extends ResponseStatusException{
	private String message;
	
	public APPSDataAccessException(HttpStatus status, String reason) {
		super(status, reason);
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	

	
	
	
}