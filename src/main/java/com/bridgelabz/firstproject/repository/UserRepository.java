package com.bridgelabz.firstproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.firstproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
//	public Optional<User> findByEmail(String email);
	List<User> findByName(String name);
	

}
