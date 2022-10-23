package com.bridgelabz.firstproject.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.firstproject.ResponseEntity;
import com.bridgelabz.firstproject.dto.UserDto;
import com.bridgelabz.firstproject.exception.UserException;
import com.bridgelabz.firstproject.model.User;
import com.bridgelabz.firstproject.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ResponseEntity addUser(User user) throws UserException {

		String userName = user.getName();
		
		if(userRepo.findByName(userName).isPresent()) {
			throw new UserException("User already exist","try to add with different user name");
		} else {
			User list1 = userRepo.save(user);		
			return new ResponseEntity(list1,"one user added");
		}
	}
	
	@Override
	public List<UserDto> getAllUser() {
		
		return userRepo.findAll().stream().map(user ->modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
		 
	}


	@Override
	public UserDto getUser(int id) throws UserException  {
		
		if(userRepo.findById(id).isPresent()) {
		Optional<User> user = userRepo.findById(id);
		UserDto userByDto = modelMapper.map(user, UserDto.class);
		return userByDto;
		
		} else {
		 throw new UserException("User not found","enter valid user id");
		}
	}
	
	@Override
	public Optional<User> getUserByName(String name) throws UserException{

			if(userRepo.findByName(name).isPresent()) {
				Optional<User> user = userRepo.findByName(name);		
			return user;
			} else {
				throw new UserException("please enter different user name","entered user is not found");
			}
			
		} 	
		
	
	

	@Override
	public void deleteUser(int id) throws UserException  {
		if(userRepo.findById(id).isPresent()) {
		userRepo.deleteById(id);
		} else {
			throw new UserException("User not deleted","enter valid id");
		}
	}

	@Override
	public User updateUser(User user, int id) throws UserException {
		if(userRepo.findById(id).isPresent()) {
			user.setId(id);
			userRepo.save(user);
		}
		return user;
	
				
		
	}


}
