package com.bridgelabz.firstproject.dto;

public class UserDto {
	
	private String name;
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public UserDto(String name, String email) {
		
		this.name = name;
		this.email = email;
	}
	
	public UserDto() {
		
	}
	
	

}
