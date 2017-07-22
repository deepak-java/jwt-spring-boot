package com.demo.jwt.auth.resource;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.stereotype.Component;

import com.demo.jwt.auth.dto.UserResponseDto;
import com.demo.jwt.auth.impl.JWTUser;
import com.demo.jwt.auth.token.JWTAuthenticationToken;

@Component
@Path("user")
public class UserResource {
	
	@GET
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserDetails(@Context SecurityContext sc){
		JWTUser user = getUser(sc.getUserPrincipal());
		List<String> roles = new ArrayList<String>();
		if(user.getAuthorities() != null)
			user.getAuthorities().forEach(authority -> roles.add(authority.toString()));
		return Response.ok(new UserResponseDto(user.getUsername(),roles)).build();
	}
	
	private JWTUser getUser(Principal principal){
		if(principal instanceof JWTAuthenticationToken){
			return (JWTUser)((JWTAuthenticationToken) principal).getPrincipal();
		}else{
			return new JWTUser(null,null,true,null);
		}
	}

}
