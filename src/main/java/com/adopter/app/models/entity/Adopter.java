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

import com.adopter.app.models.entity.region.District;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Adopter")
public class Adopter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AdopterId")
	private Long id;
	
	private String firstName;
	private String lastName;
	private String gender;
	private Date birthdate;
	private Date creationDate;
	private String phone;
	private String docNumber;
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "DocumentId")
	private Document document;
	
	@ManyToOne
	@JoinColumn(name = "DistritoID")
	private District district;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date getBirthdate() {
		return birthdate;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public Date getCreationDate() {
		return creationDate;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


	
}
