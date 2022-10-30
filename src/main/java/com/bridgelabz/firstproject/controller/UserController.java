package com.bridgelabz.firstproject.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.firstproject.ResponseEntity;
import com.bridgelabz.firstproject.dto.LoginDto;
import com.bridgelabz.firstproject.dto.UserDto;
import com.bridgelabz.firstproject.exception.UserException;
import com.bridgelabz.firstproject.model.User;
import com.bridgelabz.firstproject.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	IUserService userService;
	
		
	@PostMapping("/add")
	public ResponseEntity add(@RequestBody User user) throws UserException {		
		
		return userService.addUser(user);
		
	}
	
	@GetMapping("/getalluser")
	public List<UserDto> getAllUser() {
		
		return this.userService.getAllUser();		
	}
	
	
	@GetMapping("/search/{id}")
	public UserDto getUser(@PathVariable int id) throws UserException  {		
		
		return this.userService.getUser(id);
		
	}
	
	@GetMapping("/search")
	public Optional<User> getUserByName(@RequestParam String name) throws UserException {
		
		Optional<User> user = userService.getUserByName(name);
		return user;
		
	}
	
	
	@DeleteMapping("/delete/{id}") 
	public void deleteUser(@PathVariable int id) throws UserException  {
		
		userService.deleteUser(id);
				
	}
	
	@PutMapping("/update/{id}")
	public UserDto updateUser(@RequestBody UserDto user,@PathVariable int id) throws UserException {
		userService.updateUser(user,id);
		return user;
		
	}
	
	@GetMapping("/login")
	public ResponseEntity getUserByLoginDto(@RequestBody LoginDto loginDto) throws UserException {
		return userService.getUserByLogin(loginDto);
	}
	
	@GetMapping("/gettoken")
	public String getToken(@RequestBody LoginDto loginDto) throws UserException {
		String token = userService.getToken(loginDto);
		return token;
	}
	
	@GetMapping("/getUserByLogin")
	public ResponseEntity getUserByLogin(@RequestHeader String token) {
		UserDto userDto = userService.getUserByLogin(token);
		return new ResponseEntity(userDto, "Fetched successfully");
	}
}
