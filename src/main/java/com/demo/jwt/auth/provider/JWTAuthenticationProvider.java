package com.demo.jwt.auth.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.demo.jwt.auth.exception.BadJWTTokenException;
import com.demo.jwt.auth.token.JWTAuthenticationToken;
import com.demo.jwt.auth.token.JWTTokenDetailsService;

@Component
public class JWTAuthenticationProvider implements AuthenticationProvider {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired JWTTokenDetailsService jwtTokenDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if(!supports(authentication.getClass())){
			return null;
		}
		JWTAuthenticationToken jwtAuthToken = (JWTAuthenticationToken)authentication;
		try{
			User jwtUser = jwtTokenDetailsService.verify(jwtAuthToken.getJwtToken());
			return new JWTAuthenticationToken(jwtAuthToken.getJwtToken(),jwtUser,jwtUser.getAuthorities());
		}catch(Exception e){
			LOGGER.error("Exception while validating JWT User {}",e);
			throw new BadJWTTokenException(e.getMessage());
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return JWTAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
