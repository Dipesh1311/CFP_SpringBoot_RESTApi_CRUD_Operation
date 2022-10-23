package com.bridgelabz.firstproject.exception;

public class ErrorResponse {	
	
	private String message;
	private String Detail;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}
	
	public ErrorResponse(String message, String detail) {
		super();
		this.message = message;
		Detail = detail;
	}
	public ErrorResponse() {
		
	}
	
	

}
