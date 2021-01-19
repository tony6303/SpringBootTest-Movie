package com.cos.movie.config;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.MethodNotAllowed;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

//MethodArgumentTypeMismatchException
@RestController
@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public String 에러(MethodArgumentTypeMismatchException e) {
		return "fail(MethodArgumentTypeMismatchException Message) : " + e.getMessage();
	}
	
	@ExceptionHandler(value = BadRequest.class)
	public String 에러2(BadRequest e) {
		return "fail(BadRequest Message) : " + e.getMessage();
	}
	
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	public String 에러3(HttpRequestMethodNotSupportedException e) {
		return "fail(HttpRequestMethodNotSupportedException Message) : " + e.getMessage();
	}
}
