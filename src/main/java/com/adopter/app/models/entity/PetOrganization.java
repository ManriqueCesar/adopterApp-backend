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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.adopter.app.models.entity.region.District;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Pet_Organization")
public class PetOrganization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrganizationId")
	private Long id;
	
	private String name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
	private Date foundationDate;
	
	private Boolean status;
	
	@Column(name="LogoLink")
	private String logo;
	
	private Integer members;
	private String email;
	private String phone;
	private Date creationDate;
	
	private String WebsiteLink;
	private String InstagramLink;
	private String FacebookLink;
	private String TwitterLink;
	
	
	@ManyToOne
	@JoinColumn(name = "DistritoID")
	private District district;
	
	@ManyToOne
	@JoinColumn(name = "PetOrganizationCategoryId")
	private PetOrganizationCategory petOrganizationCategory;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date getFoundationDate() {
		return foundationDate;
	}
	

	@JsonFormat(pattern = "dd/MM/yyyy")
	public void setFoundationDate(Date foundationDate) {
		this.foundationDate = foundationDate;
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
	
	public Integer getMembers() {
		return members;
	}
	public void setMembers(Integer members) {
		this.members = members;
	}
	public PetOrganizationCategory getPetOrganizationCategory() {
		return petOrganizationCategory;
	}
	public void setPetOrganizationCategory(PetOrganizationCategory petOrganizationCategory) {
		this.petOrganizationCategory = petOrganizationCategory;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getWebsiteLink() {
		return WebsiteLink;
	}
	public void setWebsiteLink(String websiteLink) {
		WebsiteLink = websiteLink;
	}
	public String getInstagramLink() {
		return InstagramLink;
	}
	public void setInstagramLink(String instagramLink) {
		InstagramLink = instagramLink;
	}
	public String getFacebookLink() {
		return FacebookLink;
	}
	public void setFacebookLink(String facebookLink) {
		FacebookLink = facebookLink;
	}
	public String getTwitterLink() {
		return TwitterLink;
	}
	public void setTwitterLink(String twitterLink) {
		TwitterLink = twitterLink;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}


	
}
