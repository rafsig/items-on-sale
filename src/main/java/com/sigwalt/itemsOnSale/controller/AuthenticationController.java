package com.sigwalt.itemsOnSale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigwalt.itemsOnSale.config.security.TokenService;
import com.sigwalt.itemsOnSale.dto.TokenDto;
import com.sigwalt.itemsOnSale.form.CredentialsForm;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<?> auth(@RequestBody CredentialsForm credentials){
		System.out.println(credentials.getPassword());
		UsernamePasswordAuthenticationToken loginCredentials = credentials.convert();
		try {
			Authentication authentication = authManager.authenticate(loginCredentials);
			String jwt = tokenService.createToken(authentication);
			return ResponseEntity.ok(new TokenDto(jwt, "Bearer"));	
		}catch(AuthenticationException e) {
			return ResponseEntity.badRequest().build();
			
		}
		
	}
	
}
