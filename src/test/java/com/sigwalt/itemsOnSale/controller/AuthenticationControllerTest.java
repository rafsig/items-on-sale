package com.sigwalt.itemsOnSale.controller;

import java.net.URI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sigwalt.itemsOnSale.model.User;
import com.sigwalt.itemsOnSale.repository.IUserRepository;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class AuthenticationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private IUserRepository userRepo;
	
	private User user;
	
	@BeforeEach
	public void initialize() {
		User user = new User();
		user.setUserName("user12");
		user.setPassword(new BCryptPasswordEncoder().encode("password12"));
		user.setEmail("user1@email.com");
		
		this.user = userRepo.save(user);
	}
	
	@AfterEach
	public void finilize() {
		userRepo.delete(user);
	}
	
	@Test
	void userIsAuthenticatedAndJwtIsReturnedWithCorrectCredentials() throws Exception {
		URI uri = new URI("/auth");
		String jsonRequest = "{\"userName\":\"user12\", \"password\":\"password12\"}";
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers				
				.status()
				.is(200))
		.andExpect(MockMvcResultMatchers
				.jsonPath("$.string").exists())
		.andExpect(MockMvcResultMatchers
				.jsonPath("$.string").value("Bearer"))
		.andExpect(MockMvcResultMatchers
				.jsonPath("$.jwt").exists());
	}
	
	@Test
	void returnsBadRequestWhenInvalidPassword() throws Exception {
		URI uri = new URI("/auth");
		String json = "{\"userName\":\"user12\", \"password\":\"password\"}";
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));	
	}
	
	@Test
	void returnsBadRequestWhenInvalidUserName() throws Exception {
		URI uri = new URI("/auth");
		String json = "{\"userName\":\"user\", \"password\":\"password12\"}";
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));	
	}
	
	@Test
	void returnsBadRequestWhenPasswordParameterIsMissing() throws Exception {
		URI uri = new URI("/auth");
		String json = "{\"userName\":\"invalid\"}";
		String responseJson = "[{\"field\":\"password\", \"message\":\"must not be empty\"},{\"field\":\"password\", \"message\":\"must not be null\"}]";
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400))
		.andExpect(MockMvcResultMatchers
				.content()
				.json(responseJson));	
	}
	
	@Test
	void returnsBadRequestWhenUserNameParameterIsMissing() throws Exception {
		URI uri = new URI("/auth");
		String json = "{\"password\":\"invalid\"}";
		String responseJson = "[{\"field\":\"userName\", \"message\":\"must not be empty\"},{\"field\":\"userName\", \"message\":\"must not be null\"}]";
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400))
		.andExpect(MockMvcResultMatchers
				.content()
				.json(responseJson));
	}
	
	

}
