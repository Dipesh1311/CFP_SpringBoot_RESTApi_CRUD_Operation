package com.bridgelabz.firstproject.exception;


public class UserException extends Exception {
	
	
	private static final long serialVersionUID = 1L;
	private String message;
	private String details;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public UserException(String message, String details) {
		
		this.message = message;
		this.details = details;
	}
	
	
	
	
	
	

}
