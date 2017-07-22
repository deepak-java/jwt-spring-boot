package com.demo.jwt.auth.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.demo.jwt.auth.token.JWTTokenDetailsService;

@Component
public class JWTTokenDetailsServiceImpl implements JWTTokenDetailsService {
	
	@Autowired private JWTVerifier jwtVerifier;

	@Override
	public User verify(String jwtToken) {
		DecodedJWT decodedJwt = jwtVerifier.verify(jwtToken);
		String role = decodedJwt.getClaim("rol").asString();
		String username = decodedJwt.getClaim("usr").asString();
		List<GrantedAuthority> authorityList=getAuthorityList(role);
		return new JWTUser(username,jwtToken,false,authorityList);
	}
	
	private List<GrantedAuthority> getAuthorityList(String role){
		if(role != null){
			return AuthorityUtils.createAuthorityList("ROLE_"+role);
		}else{
			return AuthorityUtils.NO_AUTHORITIES;
		}
	}
}
