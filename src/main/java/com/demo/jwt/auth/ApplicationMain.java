package com.demo.jwt.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationMain {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMain.class);
	
	public static void main(String[] args) throws Exception{
		LOGGER.info("Starting JWT Authentication Application.");
		SpringApplication.run(ApplicationMain.class, args);
		LOGGER.info("JWT Authentication Application Started Successfully.");
	}

}
