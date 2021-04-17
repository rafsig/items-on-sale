package com.sigwalt.itemsOnSale.config.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.sigwalt.itemsOnSale.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	
	@Value("${com.sigwalt.jwtSecret}")
	private String secret;
	@Value("${com.sigwalt.jwtExpirationTime}")
	private String expirationLenght;
	
	public String createToken(Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		Date creation = new Date();
		Date expiration = new Date(creation.getTime() + Long.parseLong(expirationLenght));
		return Jwts.builder().setIssuer("Salte Items API")
				.setSubject(user.getId().toString())
				.setIssuedAt(creation)
				.setExpiration(expiration)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
		
	}

	public Long retrieveUserIdFromToken(String token)  {
		try {
			Long userId = Long.parseLong(Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody().getSubject());
			return userId;
		}catch(Exception e) {
			return -1L;
		}
	}

}
