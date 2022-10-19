package com.bridgelabz.firstproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	public User(String name, String email) {
		
		this.name = name;
		this.email = email;
	}
	
	public User() {
		
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	

}
