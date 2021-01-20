package com.ps.user.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.server.ServerRequest;

import ch.qos.logback.classic.Logger;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class AppsExceptionAdvice {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AppsExceptionAdvice.class);

	@ExceptionHandler(value = GlobalException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public GlobalException serverExceptionHandler(GlobalException ex) {
		LocalDateTime timeStamp = LocalDateTime.now();
		int code = ex.getStatus().value();
		String message = ex.getMessage();
		String reason = ex.getReason();
		ErrorResponse errorResponse = new ErrorResponse(timeStamp, code, message, reason, "");
		

		return ex;
	}

}
