package com.bridgelabz.firstproject.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.firstproject.ResponseEntity;
import com.bridgelabz.firstproject.dto.LoginDto;
import com.bridgelabz.firstproject.dto.UserDto;
import com.bridgelabz.firstproject.exception.UserException;
import com.bridgelabz.firstproject.model.User;
import com.bridgelabz.firstproject.repository.UserRepository;
import com.bridgelabz.firstproject.utilities.JwtTokenUtil;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@Override
	public ResponseEntity addUser(User user) throws UserException {		

		if(userRepo.findByEmail(user.getEmail()).isPresent()) {
			throw new UserException("User already exist","try to add with different user name");
		} else {
			User savedUser = userRepo.save(user);	
			UserDto registeredUserDto = modelMapper.map(savedUser, UserDto.class);
			return new ResponseEntity(registeredUserDto,"one user register successfully");
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
	public UserDto updateUser(UserDto userDto, int id) throws UserException {

		if(userRepo.findById(id).isPresent()) {	
			User user = this.userRepo.findById(id).get();

			user.setId(id);
			User updatedUser = userRepo.save(user);
			UserDto userDto1 = modelMapper.map(updatedUser, UserDto.class);
			return userDto1;

		} else {
			throw new UserException("User not updated","enter valid id");
		}		
	}

	@Override
	public ResponseEntity getUserByLogin(LoginDto loginDto) throws UserException {
		
		
		System.out.println(loginDto.getEmail()+ " "+loginDto.getPassword());

		if(userRepo.findByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword()).isPresent()) {

			Optional<User> loginUser = userRepo.findByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword());
			UserDto loginUserDto = modelMapper.map(loginUser, UserDto.class);
			return new ResponseEntity(loginUserDto,"User login successfully");
			
		} else {
			throw new UserException("User not found","enter valid email id");
		}
			

	}

	@Override
	public String getToken(LoginDto loginDto) throws UserException {

		Optional<User> userModel = userRepo.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
		if (userModel.isEmpty()) {
			throw new UserException("Invalid User!","Try again with valid credential");
		} else {
			String token = jwtTokenUtil.generateToken(loginDto);
			return token;
		}
	}

	@Override
	public UserDto getUserByLogin(String token) {
		LoginDto loginDetails = jwtTokenUtil.deCode(token);
		Optional<User> userAfterDecode = userRepo.findByEmailAndPassword(loginDetails.getEmail(), loginDetails.getPassword()); 
		UserDto userInfo = modelMapper.map(userAfterDecode, UserDto.class);
		return userInfo;
	}	

}
