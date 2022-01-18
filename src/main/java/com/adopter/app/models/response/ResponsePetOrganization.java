package com.adopter.app.models.response;

import java.util.ArrayList;

import com.adopter.app.models.dto.PetOrganizationDto;

public class ResponsePetOrganization {


	private String message;
	private ArrayList<PetOrganizationDto> petOrganization;
	private Integer httpStatus;
	
	public ResponsePetOrganization(ArrayList<PetOrganizationDto> petOrganization, String message, Integer httpStatus) {
		this.petOrganization = petOrganization;
		this.message = message;
		this.httpStatus = httpStatus;
		
	}

	public ArrayList<PetOrganizationDto> getPetOrganization() {
		return petOrganization;
	}

	public void setPetOrganization(ArrayList<PetOrganizationDto> petOrganization) {
		this.petOrganization = petOrganization;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}

}

