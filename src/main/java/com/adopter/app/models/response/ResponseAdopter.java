package com.adopter.app.models.response;

import java.util.ArrayList;

import com.adopter.app.models.dto.AdopterDto;

public class ResponseAdopter {

	private String message;
	private ArrayList<AdopterDto> adopter;
	private Integer httpStatus;
	
	public ResponseAdopter(ArrayList<AdopterDto> adopter, String message, Integer httpStatus) {
		this.adopter=adopter;
		this.message = message;
		this.httpStatus = httpStatus;
	}


	public ArrayList<AdopterDto> getAdopter() {
		return adopter;
	}

	public void setAdopter(ArrayList<AdopterDto> adopter) {
		this.adopter = adopter;
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

