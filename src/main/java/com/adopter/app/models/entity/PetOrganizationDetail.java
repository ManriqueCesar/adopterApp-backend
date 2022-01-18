package com.adopter.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pet_Organization_Detail")
public class PetOrganizationDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PetOrganizationDetailId")
	private Long id;
	
	private Integer attemptsAvailable;
	
	@ManyToOne
	@JoinColumn(name = "OrganizationId")
	private PetOrganization petOrganization;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getAttemptsAvailable() {
		return attemptsAvailable;
	}

	public void setAttemptsAvailable(Integer attemptsAvailable) {
		this.attemptsAvailable = attemptsAvailable;
	}

	public PetOrganization getPetOrganization() {
		return petOrganization;
	}

	public void setPetOrganization(PetOrganization petOrganization) {
		this.petOrganization = petOrganization;
	}


	
}
