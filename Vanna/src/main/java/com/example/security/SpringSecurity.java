package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


import com.example.security.service.CustomTeacherData;
import com.example.security.service.CustomTeacherDetails;

@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userdetailservice;
	
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userdetailservice);
		
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeHttpRequests().antMatchers("/").hasRole("ROLE_ADMIN").and().formLogin();
		
		
	}
	

}
