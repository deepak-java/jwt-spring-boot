package com.demo.jwt.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.Http401AuthenticationEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.demo.jwt.auth.filter.JWTAuthenticationFilter;
import com.demo.jwt.auth.provider.JWTAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecuriryConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired private JWTAuthenticationProvider jwtAuthenticationProvier;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .addFilterBefore(new JWTAuthenticationFilter(), BasicAuthenticationFilter.class)
                .csrf().disable()
            .exceptionHandling().authenticationEntryPoint(new Http401AuthenticationEntryPoint(""));
    }
	
	@Override
	public void configure(AuthenticationManagerBuilder authManagerBuilder){
		authManagerBuilder
			.authenticationProvider(jwtAuthenticationProvier);
	}

}
