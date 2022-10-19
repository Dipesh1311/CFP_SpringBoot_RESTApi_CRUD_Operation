package com.bridgelabz.firstproject.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.firstproject.ResponseEntity;
import com.bridgelabz.firstproject.exception.UserNotFoundException;
import com.bridgelabz.firstproject.model.User;
import com.bridgelabz.firstproject.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public ResponseEntity addUser(User user) {
	
		User list1 = userRepo.save(user);		
		return new ResponseEntity(list1,"one user added");
	}
	
	@Override
	public List<User> getAllUser() {
		
		List<User> allUser = userRepo.findAll();
		return allUser;
	}


	@Override
	public Optional<User> getUser(int id) throws UserNotFoundException  {
		
		if(userRepo.findById(id).isPresent()) {
		Optional<User> user = userRepo.findById(id);
		return user;
		
		} else {
		 throw new UserNotFoundException("User not found");
		}
	}
	
	@Override
	public List<User> getUserByName(String name) {
		List<User> user = userRepo.findByName(name);
		return user;
	}

	@Override
	public void deleteUser(int id) {
		
		if(userRepo.findById(id).isPresent()) {			
			userRepo.deleteById(id);
			System.out.println("ID "+id+" user deleted");
		
		} else {
			System.out.println("ID "+id+" user not found");
		}	
	}

	@Override
	public User updateUser(User user, int id) {
		if(userRepo.findById(id).isPresent()) {
			user.setId(id);
			userRepo.save(user);
		}
		return user;		
		
	}

}
