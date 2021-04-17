package com.sigwalt.itemsOnSale.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CredentialsForm {
	
	private String userName;
	private String password;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UsernamePasswordAuthenticationToken convert() {
		return new UsernamePasswordAuthenticationToken(userName, password);
	}
	
	

}
