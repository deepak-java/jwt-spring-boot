package com.demo.jwt.auth.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.demo.jwt.auth.resource.UserResource;

@Configuration
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig(){
		register(UserResource.class);
	}
}
