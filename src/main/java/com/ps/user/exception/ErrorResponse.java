package com.ps.user.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class  ErrorResponse {
	    private LocalDateTime timeStamp;
		private String message ;
		private int code  ;
		private String path;

	public ErrorResponse(LocalDateTime timeStamp,int code, String message, String trim, String path) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.code = code;
		this.path = path;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ErrorResponse [timeStamp=" + timeStamp + ", message=" + message + ", code=" + code + ", path=" + path
				+ "]";
	}
	

}
