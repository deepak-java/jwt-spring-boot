package com.demo.jwt.auth.exception;

import org.springframework.security.core.AuthenticationException;

public class BadJWTTokenException extends AuthenticationException{
	
	private static final long serialVersionUID = 20170722155706L;

	public BadJWTTokenException(String message){
		super(message);
	}

}
