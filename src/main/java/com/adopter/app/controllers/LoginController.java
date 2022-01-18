package com.adopter.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adopter.app.models.dto.UserDto;
import com.adopter.app.models.response.LoginResponseModel;
import com.adopter.app.services.IAuthService;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private IAuthService authService;
	
	@PostMapping
	public LoginResponseModel login(@RequestBody UserDto usuario) {
		return  authService.login(usuario);
		
	}
	
}
