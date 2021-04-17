package com.sigwalt.itemsOnSale.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sigwalt.itemsOnSale.model.User;
import com.sigwalt.itemsOnSale.repository.IUserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUserName(username);
		if(user.isPresent())
			return user.get();
		
		throw new UsernameNotFoundException("Invalid credentials");
	}

}
