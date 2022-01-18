package com.adopter.app.models.dto;

import java.util.Date;

import com.adopter.app.models.entity.AdopterDetail;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AdopterDto {

	private Long idAdopter;
	private String organizationName;
	private Long idOrganization;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String phone;
	private Long idDistrito;
	private String distrito;
	private Long idProvincia;
	private String provincia;
	private Long idDepartamento;
	private String departamento;
	private Long idDocument;
	private String documentType;
	private String gender;
	private Date creationDate;
	private Long idDocumentNumber;
	private String documentNumber;
	private Long idSeverity;
	private String severity;
	private String comments;
	private String evidence;
	private Date issueDate;
	private Date commentaryCreationDate;
	private Boolean status;
	
	public AdopterDto() {
		
	}

	public AdopterDto(AdopterDetail adopter) {
		this.organizationName = adopter.getPetOrganization().getName();
		this.idOrganization = adopter.getPetOrganization().getId();
		
		this.idAdopter = adopter.getAdopter().getId();
		this.firstName = adopter.getAdopter().getFirstName();
		this.lastName = adopter.getAdopter().getLastName();
		this.creationDate = adopter.getAdopter().getCreationDate();
		this.birthDate = adopter.getAdopter().getBirthdate();
		this.phone = adopter.getAdopter().getPhone();
		this.gender = adopter.getAdopter().getGender();
		this.documentNumber = adopter.getAdopter().getDocNumber();
		this.idDistrito = adopter.getAdopter().getDistrict().getId();
		this.distrito = adopter.getAdopter().getDistrict().getDistrict();
		this.idProvincia = adopter.getAdopter().getDistrict().getProvince().getId();
		this.provincia = adopter.getAdopter().getDistrict().getProvince().getProvince();
		this.idDepartamento = adopter.getAdopter().getDistrict().getProvince().getDepartment().getId();
		this.departamento = adopter.getAdopter().getDistrict().getProvince().getDepartment().getDepartment();
		this.idDocument = adopter.getAdopter().getDocument().getId();
		this.documentType = adopter.getAdopter().getDocument().getDescription();
		this.idSeverity = adopter.getAdopterSeverity().getId();
		this.severity = adopter.getAdopterSeverity().getDescription();
		this.status = adopter.getAdopter().getStatus();
		
		this.evidence = adopter.getEvidence();
		this.comments = adopter.getComment();
		this.issueDate = adopter.getIssueDate();
		this.commentaryCreationDate = adopter.getCommentaryCreationDate();
	}

	
	
	public Long getIdOrganization() {
		return idOrganization;
	}

	public Long getIdDistrito() {
		return idDistrito;
	}

	public Long getIdAdopter() {
		return idAdopter;
	}

	public void setIdAdopter(Long idAdopter) {
		this.idAdopter = idAdopter;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
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

	@JsonFormat(pattern = "dd/MM/yyyy")
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date getCreationDate() {
		return creationDate;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getIdDocumentNumber() {
		return idDocumentNumber;
	}

	public void setIdDocumentNumber(Long idDocumentNumber) {
		this.idDocumentNumber = idDocumentNumber;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getEvidence() {
		return evidence;
	}

	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date getIssueDate() {
		return issueDate;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public void setIdOrganization(Long idOrganization) {
		this.idOrganization = idOrganization;
	}


	public void setIdDistrito(Long idDistrito) {
		this.idDistrito = idDistrito;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Long getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date getCommentaryCreationDate() {
		return commentaryCreationDate;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public void setCommentaryCreationDate(Date commentaryCreationDate) {
		this.commentaryCreationDate = commentaryCreationDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
