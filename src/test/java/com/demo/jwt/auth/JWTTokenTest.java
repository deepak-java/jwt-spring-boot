package com.demo.jwt.auth;

import java.util.Calendar;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTTokenTest {

	public static void main(String[] args) throws Exception{
		
		Algorithm algorithm = Algorithm.HMAC256("d11da713ebeeaf256ba5adc5d21ec1b8fd1da68c99a4fb90cf17bd02d1f92ff1s");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 5);
		String token = JWT.create()
				.withExpiresAt(calendar.getTime())
				.withClaim("rol", "ADMIN")
				.withClaim("usr","demouser")
				.sign(algorithm);
		System.out.println("Bearer "+token);
	}

}
