package com.bridgelabz.firstproject.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserDto {
	
	@NotEmpty
	@Size(min=3)
	private String name;
	
	@Email
	private String email;
	
	@NotNull
	private Long mobileNumber;
	
	@NotEmpty
	private String gender;
	
	@NotEmpty
	@Size(min=6)
	private String password;
	

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
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDto(String name, String email, Long mobileNumber, String gender, String password) {
		
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.password = password;
	}
	
	public UserDto() {
		
	}
}
