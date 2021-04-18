package com.sigwalt.itemsOnSale.controller;

import java.net.URI;

import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sigwalt.itemsOnSale.model.User;
import com.sigwalt.itemsOnSale.repository.IUserRepository;

import net.minidev.json.JSONArray;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class RecommendedListControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private IUserRepository userRepo;
	
	private User user;
	
	private String jwt;
	
	@BeforeEach
	public void initialize() throws Exception {
		User user = new User();
		user.setUserName("user12");
		user.setPassword(new BCryptPasswordEncoder().encode("password12"));
		user.setEmail("user1@email.com");

		this.user = userRepo.save(user);
		 
		URI uri = new URI("/auth");
		String json = "{\"userName\":\"user12\", \"password\":\"password12\"}";
		  MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)).andReturn();
		  String response = mvcResult.getResponse().getContentAsString();
		  JSONObject responseJson = new JSONObject(response);
		  this.jwt = responseJson.getString("jwt");
	}
	
	@AfterEach
	public void finilize() {
		userRepo.delete(user);
	}

	@Test
	void nonAuthenticatedUserGets403Response() throws Exception {
		URI uri = new URI("/recommendations/1");
		mockMvc.perform(MockMvcRequestBuilders
				.get(uri))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(403));	
	}
	
	@Test
	void authenticatedUserGetsListsOfRecommendedItemsWhenAuthenticated() throws Exception{
		URI uri = new URI("/recommendations/1");
		JSONObject json = new JSONObject();
		json.put("ItemsFromIntestCategories", new JSONObject());
		json.put("HotDeals", new JSONObject());
		json.put("WishList", new JSONObject());
		
		System.out.println(json.toString());
		mockMvc.perform(MockMvcRequestBuilders
				.get(uri)
				.header("authorization", "Bearer " + this.jwt))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200))
		.andExpect(MockMvcResultMatchers
				.content().json(json.toString()));  
	}
	
	@Test
	void authenticatedUserGets404WhenIdIsNonExistent() throws Exception{
		URI uri = new URI("/recommendations/-1");
		mockMvc.perform(MockMvcRequestBuilders
				.get(uri)
				.header("authorization", "Bearer " + this.jwt))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(404));  
	}

}
