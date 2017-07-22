package com.demo.jwt.auth.token;

import org.springframework.security.core.userdetails.User;

public interface JWTTokenDetailsService {
	
	public User verify(String jwtToken);
}
