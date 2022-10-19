package com.bridgelabz.firstproject.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserException> handleUserNotFoundException(Exception exception, WebRequest request){
		UserException userException = new UserException("Not Found","Enter Valid user id");

		return new ResponseEntity<UserException>(userException,HttpStatus.BAD_REQUEST);
	}

}
