package com.demo.jwt.auth.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class JWTUser extends User{
	
	private static final long serialVersionUID = 20170722140314l;
	
	private String jwtToken;
	
	public JWTUser(String username, String jwtToken, boolean isExpired, Collection<? extends GrantedAuthority> authorities){
		super(username,jwtToken,true,true,!isExpired,true,authorities);
		this.jwtToken=jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

}
