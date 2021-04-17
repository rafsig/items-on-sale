package com.sigwalt.itemsOnSale.dto;

public class TokenDto {

	private String jwt;
	private String string;

	public TokenDto(String jwt, String string) {
		this.jwt = jwt;
		this.string = string;
	}

	public String getJwt() {
		return jwt;
	}

	public String getString() {
		return string;
	}	
	
}
