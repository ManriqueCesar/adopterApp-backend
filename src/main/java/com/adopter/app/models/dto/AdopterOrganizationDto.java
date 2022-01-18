package com.adopter.app.models.dto;

import java.util.Date;

import com.adopter.app.models.entity.AdopterDetail;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AdopterOrganizationDto {

	private Long idOrganization;
	private String organizationName;
	private String logo;

	private String firstName;
	private String lastName;
	private Date birthDate;
	private String phone;
	private Long idDistrito;
	private String documentType;
	private String gender;
	private Long idDocument;
	private Long idSeverity;
	private String severity;
	
	public AdopterOrganizationDto(AdopterDetail adopter) {
		this.idOrganization = adopter.getPetOrganization().getId();
		this.organizationName = adopter.getPetOrganization().getName();
		this.logo = adopter.getPetOrganization().getLogo();
		this.firstName = adopter.getAdopter().getFirstName();
		this.lastName = adopter.getAdopter().getLastName();
		this.birthDate = adopter.getAdopter().getBirthdate();
		this.phone = adopter.getAdopter().getPhone();
		this.idDistrito = adopter.getAdopter().getDistrict().getId();
		this.gender = adopter.getAdopter().getGender();
		this.documentType = adopter.getAdopter().getDocument().getDescription();
		this.idDocument = adopter.getAdopter().getDocument().getId();
		this.severity = adopter.getAdopterSeverity().getDescription();
		this.idSeverity = adopter.getAdopterSeverity().getId();
	}

	public AdopterOrganizationDto() {
	}

	public Long getOrganizationId() {
		return idOrganization;
	}

	public void setOrganizationId(Long organizationId) {
		this.idOrganization = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(Long idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getDocumentNumber() {
		return documentType;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentType = documentNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getIdOrganization() {
		return idOrganization;
	}

	public void setIdOrganization(Long idOrganization) {
		this.idOrganization = idOrganization;
	}

	public Long getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	public Long getIdSeverity() {
		return idSeverity;
	}

	public void setIdSeverity(Long idSeverity) {
		this.idSeverity = idSeverity;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

}
