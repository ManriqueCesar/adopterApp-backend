package com.adopter.app.services;

import com.adopter.app.models.dto.UserDto;
import com.adopter.app.models.response.LoginResponseModel;

public interface IAuthService {

	public LoginResponseModel login(UserDto cliente);
}
