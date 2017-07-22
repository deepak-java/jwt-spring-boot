package com.demo.jwt.auth.dto;

import java.util.List;

public class UserResponseDto {
	
	private String username;
	private List<?> roles;
	
	public UserResponseDto(String username, List<?> roles){
		this.username=username;
		this.roles=roles;
	}

	public String getUsername() {
		return username;
	}

	public List<?> getRoles() {
		return roles;
	}

}
