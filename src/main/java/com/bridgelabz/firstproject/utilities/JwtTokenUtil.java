package com.bridgelabz.firstproject.utilities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.bridgelabz.firstproject.dto.LoginDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	LoginDto loginDto = new LoginDto();

	private static final long serialVersionUID = 1L;

	private String secret = "springjwttoken";

	
	
	public String generateToken(LoginDto loginDto) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("Email", loginDto.getEmail());
		claims.put("Password", loginDto.getPassword()); 

		System.out.println("claims : " + claims);
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512,secret).compact();

	}

	public LoginDto deCode(String token) {

		final Map<String, Object> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody(); 
		loginDto.setEmail((String) claims.get("Email"));
		loginDto.setPassword((String) claims.get("Password"));
		
		return loginDto;


	}




}
