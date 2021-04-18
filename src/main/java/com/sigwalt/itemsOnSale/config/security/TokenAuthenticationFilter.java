package com.sigwalt.itemsOnSale.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sigwalt.itemsOnSale.model.User;
import com.sigwalt.itemsOnSale.repository.IUserRepository;

public class TokenAuthenticationFilter extends OncePerRequestFilter {
	
	TokenService tokenService;
	IUserRepository userRepo;
	
	

	public TokenAuthenticationFilter(TokenService tokenService, IUserRepository userRepo) {
		this.userRepo = userRepo;
		this.tokenService = tokenService;
	}



	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = retrieveToken(request);
		Long userId = tokenService.retrieveUserIdFromToken(token);
		if(userId != -1){
			authenticateClient(userId);
		}
		filterChain.doFilter(request, response);
		
	}



	private void authenticateClient(Long userId) {
		User user = userRepo.findById(userId).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getId(), null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}



	private String retrieveToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7, token.length());
	}

}
