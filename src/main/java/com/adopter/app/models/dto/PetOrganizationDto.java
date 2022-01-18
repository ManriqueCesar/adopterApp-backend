package com.adopter.app.models.dto;

import java.util.Date;


import com.adopter.app.models.entity.PetOrganizationDetail;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PetOrganizationDto {

	private Long idOrganization;
	private String nombre;
	private Date fechaFundacion;
	private Boolean status;
	private String logo;
	private String distrito;
	private Long idDistrito;
	private String provincia;
	private Long idProvincia;
	private String phone;
	private Date fechaRegistro;
	private String departamento;
	private Long idDepartamento;
	private Integer cantidadMiembros;
	private Integer intentos;
	private Integer intentosDisponibles;
	private Long idOrganizacionDetalle;
	private Long idOrganizacionCategoria;
	private String tipoOrganizacionCategoria;

	private String email;
	private String websiteLink;
	private String facebookLink;
	private String instagramLink;
	private String twitterLink;

	public PetOrganizationDto() {
	}

	public PetOrganizationDto(PetOrganizationDetail petOrg) {
		this.idOrganization = petOrg.getPetOrganization().getId();
		this.nombre = petOrg.getPetOrganization().getName();
		this.fechaFundacion = petOrg.getPetOrganization().getFoundationDate();
		this.status = petOrg.getPetOrganization().getStatus();
		this.intentos = petOrg.getPetOrganization().getPetOrganizationCategory().getAttempts();
		this.intentosDisponibles = petOrg.getAttemptsAvailable();
		this.logo = petOrg.getPetOrganization().getLogo();
		this.distrito = petOrg.getPetOrganization().getDistrict().getDistrict();
		this.idDistrito = petOrg.getPetOrganization().getDistrict().getId();
		this.provincia = petOrg.getPetOrganization().getDistrict().getProvince().getProvince();
		this.departamento = petOrg.getPetOrganization().getDistrict().getProvince().getDepartment().getDepartment();
		this.idProvincia = petOrg.getPetOrganization().getDistrict().getProvince().getId();
		this.idDepartamento = petOrg.getPetOrganization().getDistrict().getProvince().getDepartment().getId();
		this.cantidadMiembros = petOrg.getPetOrganization().getMembers();
		this.idOrganizacionDetalle = petOrg.getId();
		this.idOrganizacionCategoria = petOrg.getPetOrganization().getPetOrganizationCategory().getId();
		this.tipoOrganizacionCategoria = petOrg.getPetOrganization().getPetOrganizationCategory().getType();
		this.fechaRegistro = petOrg.getPetOrganization().getCreationDate();
		this.email = petOrg.getPetOrganization().getEmail();
		this.phone = petOrg.getPetOrganization().getPhone();

		this.websiteLink = petOrg.getPetOrganization().getWebsiteLink();
		this.facebookLink = petOrg.getPetOrganization().getFacebookLink();
		this.instagramLink = petOrg.getPetOrganization().getInstagramLink();
		this.twitterLink = petOrg.getPetOrganization().getTwitterLink();

	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public Long getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(Long idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Integer getCantidadMiembros() {
		return cantidadMiembros;
	}

	public void setCantidadMiembros(Integer cantidadMiembros) {
		this.cantidadMiembros = cantidadMiembros;
	}

	public Integer getIntentosDisponibles() {
		return intentosDisponibles;
	}

	public void setIntentosDisponibles(Integer intentosDisponibles) {
		this.intentosDisponibles = intentosDisponibles;
	}

	public Long getIdOrganizacionDetalle() {
		return idOrganizacionDetalle;
	}

	public void setIdOrganizacionDetalle(Long idOrganizacionDetalle) {
		this.idOrganizacionDetalle = idOrganizacionDetalle;
	}

	public Long getIdOrganizacionCategoria() {
		return idOrganizacionCategoria;
	}

	public void setIdOrganizacionCategoria(Long idOrganizacionCategoria) {
		this.idOrganizacionCategoria = idOrganizacionCategoria;
	}

	public String getTipoOrganizacionCategoria() {
		return tipoOrganizacionCategoria;
	}

	public void setTipoOrganizacionCategoria(String tipoOrganizacionCategoria) {
		this.tipoOrganizacionCategoria = tipoOrganizacionCategoria;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date getFechaFundacion() {
		return fechaFundacion;
	}
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	public void setFechaFundacion(Date fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date getFechaCreacion() {
		return fechaRegistro;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaRegistro = fechaCreacion;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public String getFacebookLink() {
		return facebookLink;
	}

	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}

	public String getInstagramLink() {
		return instagramLink;
	}

	public void setInstagramLink(String instagramLink) {
		this.instagramLink = instagramLink;
	}

	public String getTwitterLink() {
		return twitterLink;
	}

	public void setTwitterLink(String twitterLink) {
		this.twitterLink = twitterLink;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIntentos() {
		return intentos;
	}

	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}

	public Long getIdOrganization() {
		return idOrganization;
	}

	public void setIdOrganization(Long idOrganization) {
		this.idOrganization = idOrganization;
	}

}
