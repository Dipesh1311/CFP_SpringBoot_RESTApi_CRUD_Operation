package com.bridgelabz.firstproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.firstproject.dto.LoginDto;
import com.bridgelabz.firstproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	Optional<User> findByName(String name);
	public Optional<User> findByEmail( String email);
	public Optional<User> findByPassword(String password);
	public Optional<User> findByEmailAndPassword(String email,String password);

}
