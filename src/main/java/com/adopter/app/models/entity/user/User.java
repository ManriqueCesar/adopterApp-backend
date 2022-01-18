package com.adopter.app.models.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.adopter.app.models.entity.PetOrganization;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserId")
	private Long id;
	
	private String username;
	private String password;
	private Boolean enabled;
	
	@ManyToOne
	@JoinColumn(name = "OrganizationId")
	private PetOrganization petOrganization;
	
	public User() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public PetOrganization getPetOrganization() {
		return petOrganization;
	}

	public void setPetOrganization(PetOrganization petOrganization) {
		this.petOrganization = petOrganization;
	}
	
}
