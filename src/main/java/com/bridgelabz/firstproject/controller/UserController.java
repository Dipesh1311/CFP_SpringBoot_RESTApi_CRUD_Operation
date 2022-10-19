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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.firstproject.ResponseEntity;
import com.bridgelabz.firstproject.exception.UserNotFoundException;
import com.bridgelabz.firstproject.model.User;
import com.bridgelabz.firstproject.repository.UserRepository;
import com.bridgelabz.firstproject.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	IUserService userService;
	User user;
	UserRepository userRepo;
		
	@PostMapping("/add")
	public ResponseEntity add(@RequestBody User user) {		
		
		return userService.addUser(user);
		
	}
	
	@GetMapping("/getalluser")
	public List<User> getAllUser() {
		
		return this.userService.getAllUser();		
	}
	
	
	@GetMapping("/search/{id}")
	public Optional<User> getUser(@PathVariable int id) throws UserNotFoundException  {		
		
		System.out.println("ID "+id+" data");
		return this.userService.getUser(id);
		
	}
	
	@GetMapping("/search")
	public List<User> getUserByName(@RequestParam String name){
		
		List<User> user = userService.getUserByName(name);
		return user;
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable int id) {
		
		userService.deleteUser(id);
				
	}
	
	@PutMapping("/update/{id}")
	public User updateUser(@RequestBody User user,@PathVariable int id) {
		userService.updateUser(user,id);
		return user;
		
	}
	
}
