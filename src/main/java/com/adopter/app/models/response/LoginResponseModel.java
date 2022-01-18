package com.adopter.app.models.response;

import com.adopter.app.models.dto.UserDto;

public class LoginResponseModel {
	private String token;
	private String message;
	private UserDto usuario;
	//private List<UsuarioPermisosDto> opcionSistemaRol;
	private Integer httpStatus;
	
	public LoginResponseModel(String token ,UserDto usuarioModelo, /*List<UsuarioPermisosDto> opcionSistemaRol,*/ String message , Integer httpStatus ) {
		this.usuario=usuarioModelo;
		//this.opcionSistemaRol = opcionSistemaRol;
		this.message = message;
		this.httpStatus = httpStatus;
		this.token= token;

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UserDto usuario) {
		this.usuario = usuario;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
}
