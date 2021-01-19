package com.ps.user.exception;

public class AlreadyExistsException extends RuntimeException{
	
	private String message ;

	public AlreadyExistsException(String message) {
		super();
		this.message = message;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}