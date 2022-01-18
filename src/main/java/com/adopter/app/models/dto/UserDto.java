package com.adopter.app.models.dto;

import com.adopter.app.models.entity.user.UserRole;

public class UserDto {

	private String usuario;
	private Long idUsuario;
	private String contrasena;
	private Boolean habilitado;
	private Long idOrganization;

	public UserDto() {
	}
	
	public UserDto(UserRole user) {
		this.idUsuario = user.getRol().getId();
		this.usuario= user.getUsuario().getUsername();
		this.contrasena = user.getUsuario().getPassword();
		this.habilitado = user.getUsuario().getEnabled();
		this.idOrganization = user.getUsuario().getPetOrganization().getId();
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Long getIdOrganization() {
		return idOrganization;
	}

	public void setIdOrganization(Long idOrganization) {
		this.idOrganization = idOrganization;
	}

}
