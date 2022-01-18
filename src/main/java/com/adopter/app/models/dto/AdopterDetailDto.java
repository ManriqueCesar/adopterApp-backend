package com.adopter.app.models.dto;

import java.util.Date;

import com.adopter.app.models.entity.AdopterDetail;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AdopterDetailDto {

	private Long idAdopter;
	private String organizationName;
	private String organizationLogo;
	private Long idOrganization;
	private Date birthDate;
	private Date creationDate;
	private String severity;
	private String comments;
	private String evidence;
	private Date issueDate;
	private Date commentaryCreationDate;

	public AdopterDetailDto() {

	}

	public AdopterDetailDto(AdopterDetail adopter) {
		this.organizationName = adopter.getPetOrganization().getName();
		this.idOrganization = adopter.getPetOrganization().getId();
		this.organizationLogo = adopter.getPetOrganization().getLogo();
		this.idAdopter = adopter.getAdopter().getId();
		this.creationDate = adopter.getAdopter().getCreationDate();
		this.birthDate = adopter.getAdopter().getBirthdate();
		this.severity = adopter.getAdopterSeverity().getDescription();

		this.evidence = adopter.getEvidence();
		this.comments = adopter.getComment();
		this.issueDate = adopter.getIssueDate();
		this.commentaryCreationDate = adopter.getCommentaryCreationDate();
	}

	public Long getIdOrganization() {
		return idOrganization;
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

	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date getBirthDate() {
		return birthDate;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date getCreationDate() {
		return creationDate;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date getCommentaryCreationDate() {
		return commentaryCreationDate;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public void setCommentaryCreationDate(Date commentaryCreationDate) {
		this.commentaryCreationDate = commentaryCreationDate;
	}

	public String getOrganizationLogo() {
		return organizationLogo;
	}

	public void setOrganizationLogo(String organizationLogo) {
		this.organizationLogo = organizationLogo;
	}
	
	
}
