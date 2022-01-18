package com.adopter.app.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adopter.app.models.dto.UserDto;
import com.adopter.app.models.repository.UserRepository;

import org.springframework.security.core.GrantedAuthority;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        UserDto user = userRepo.findByUsuario(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found with username: " + username);
	        }
	        return new org.springframework.security.core.userdetails.User(user.getUsuario(), user.getContrasena(),
	                new ArrayList<GrantedAuthority>());
	    }

}
