package com.example.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import antlr.collections.List;

public class CustomTeacherData implements UserDetails {
	
	private String userName;
	
	public CustomTeacherData(String Username) {
		this.userName = Username;
	}

	public CustomTeacherData() {};
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<String> s = new HashSet<>();
		s.add("ADMIN");
		
		return s.stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role)).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return "manav";
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return "manav";
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
