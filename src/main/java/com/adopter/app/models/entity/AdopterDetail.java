package com.adopter.app.models.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Adopter_Detail")
public class AdopterDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AdopterDetailId")
	private Long id;
	
	private Date issueDate;
	private Date commentaryCreationDate;
	private String comment;
	private String evidence;

	@ManyToOne
	@JoinColumn(name = "OrganizationId")
	private PetOrganization petOrganization;
	
	@ManyToOne
	@JoinColumn(name = "SeverityId")
	private AdopterSeverity adopterSeverity;
	
	@ManyToOne
	@JoinColumn(name = "AdopterId")
	private Adopter adopter;
	

	public AdopterDetail() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date getIssueDate() {
		return issueDate;
	}
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getEvidence() {
		return evidence;
	}

	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	public PetOrganization getPetOrganization() {
		return petOrganization;
	}

	public void setPetOrganization(PetOrganization petOrganization) {
		this.petOrganization = petOrganization;
	}

	public AdopterSeverity getAdopterSeverity() {
		return adopterSeverity;
	}

	public void setAdopterSeverity(AdopterSeverity adopterSeverity) {
		this.adopterSeverity = adopterSeverity;
	}

	public Adopter getAdopter() {
		return adopter;
	}

	public void setAdopter(Adopter adopter) {
		this.adopter = adopter;
	}

	public Date getCommentaryCreationDate() {
		return commentaryCreationDate;
	}

	public void setCommentaryCreationDate(Date commentaryCreationDate) {
		this.commentaryCreationDate = commentaryCreationDate;
	}
	
	
}
