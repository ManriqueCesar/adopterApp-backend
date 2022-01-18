package com.adopter.app.models.response;

public class ResponseModel {

	private String message;
	private Integer httpStatus;
	
	public ResponseModel(String message, Integer httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
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
