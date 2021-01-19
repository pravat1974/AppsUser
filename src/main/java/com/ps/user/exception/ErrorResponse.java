package com.ps.user.exception;

import org.springframework.http.HttpStatus;

public class  ErrorResponse {
		private String message ;
		private int code  ;
		private String path;

	public ErrorResponse(int code, String message, String trim, String path) {
		this.message = message;
		this.code = code;
		this.path = path;
	}

}
