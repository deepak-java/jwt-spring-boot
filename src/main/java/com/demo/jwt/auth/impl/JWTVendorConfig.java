package com.demo.jwt.auth.impl;

import java.io.UnsupportedEncodingException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

@Configuration
public class JWTVendorConfig {
	
	private static final String HMAC_KEY_SECRET = "d11da713ebeeaf256ba5adc5d21ec1b8fd1da68c99a4fb90cf17bd02d1f92ff1s";
	
	@Bean
	public JWTVerifier jwtVerifier() throws IllegalArgumentException, UnsupportedEncodingException{
		Algorithm algorithm = Algorithm.HMAC256(HMAC_KEY_SECRET);
		JWTVerifier verifier = JWT.require(algorithm)
				.build();
		return verifier;
	}

}
