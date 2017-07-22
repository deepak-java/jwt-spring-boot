package com.demo.jwt.auth.token;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class JWTAuthenticationToken extends AbstractAuthenticationToken{
	
	private static final long serialVersionUID = 20170722132455l;
	
	private String token;
	private User user;
	
	public JWTAuthenticationToken(String jwtToken){
		super(null);
		this.token=jwtToken;
		super.setAuthenticated(false);
	}
	
	public JWTAuthenticationToken(String token, User user, Collection<? extends GrantedAuthority> authorities){
		super(authorities);
		this.token=token;
		this.user=user;
		super.setAuthenticated(true);
	}

	public String getJwtToken() {
		return token;
	}

	@Override
	public Object getCredentials() {
		return token;
	}

	@Override
	public Object getPrincipal() {
		return user;
	}
	
	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		if (isAuthenticated) {
			throw new IllegalArgumentException(
					"Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
		}
		super.setAuthenticated(false);
	}

	
}
