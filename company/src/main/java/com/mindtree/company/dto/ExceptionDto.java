package com.mindtree.company.dto;

public class ExceptionDto {
	private String message;

	public ExceptionDto(String message) {
		super();
		this.message = message;
	}

	public ExceptionDto() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public ExceptionDto(String message, Throwable cause) {
		super();
		this.message = message;
	}
}
