package com.bridgelabz.firstproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(UserException.class)
	@ResponseStatus
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserException exception){
		ErrorResponse er = new ErrorResponse();
		er.setMessage(exception.getMessage());
		er.setDetail(exception.getDetails());
		return new ResponseEntity<ErrorResponse>(er,HttpStatus.BAD_REQUEST);
	}

}
