package com.demo.jwt.auth.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.demo.jwt.auth.token.JWTAuthenticationToken;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (authHeader != null) {
			String[] splitedAuthHeader = authHeader.split(" ");
			if (splitedAuthHeader.length == 2) {
				if (splitedAuthHeader[0].equalsIgnoreCase("Bearer")) {
					SecurityContextHolder.getContext()
							.setAuthentication(new JWTAuthenticationToken(splitedAuthHeader[1]));
				}
			}
		}
		filterChain.doFilter(request, response);
	}
}
