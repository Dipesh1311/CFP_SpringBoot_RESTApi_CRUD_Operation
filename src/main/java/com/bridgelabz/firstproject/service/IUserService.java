package com.bridgelabz.firstproject.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.firstproject.ResponseEntity;
import com.bridgelabz.firstproject.exception.UserNotFoundException;
import com.bridgelabz.firstproject.model.User;

public interface IUserService {
	
	public ResponseEntity addUser(User user);

	public Optional<User> getUser(int id) throws UserNotFoundException ;

	public void deleteUser(int id);

	public User updateUser(User user, int id);

	public List<User> getAllUser();

	public List<User> getUserByName(String name);	

}
