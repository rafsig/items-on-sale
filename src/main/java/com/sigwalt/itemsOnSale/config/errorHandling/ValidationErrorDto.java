package com.sigwalt.itemsOnSale.config.errorHandling;

public class ValidationErrorDto {

	private String field;
	private String message;

	public ValidationErrorDto(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}
	
	


}
