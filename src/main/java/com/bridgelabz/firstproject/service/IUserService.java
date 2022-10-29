package com.bridgelabz.firstproject.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.firstproject.ResponseEntity;
import com.bridgelabz.firstproject.dto.LoginDto;
import com.bridgelabz.firstproject.dto.UserDto;
import com.bridgelabz.firstproject.exception.UserException;
import com.bridgelabz.firstproject.model.User;

public interface IUserService {
	
	public ResponseEntity addUser(User user) throws UserException;

	public UserDto getUser(int id) throws UserException ;

	public void deleteUser(int id) throws UserException ;

	public UserDto updateUser(UserDto userDto, int id) throws UserException;

	public List<UserDto> getAllUser();

	public Optional<User> getUserByName(String name) throws UserException;	
	
	public ResponseEntity getUserByLogin(LoginDto loginDto) throws UserException;
	


}
