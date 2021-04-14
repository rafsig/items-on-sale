package com.sigwalt.itemsOnSale.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sigwalt.itemsOnSale.dto.ItemDto;
import com.sigwalt.itemsOnSale.model.User;
import com.sigwalt.itemsOnSale.repository.IItemRepository;
import com.sigwalt.itemsOnSale.repository.IUserRepository;
import com.sigwalt.itemsOnSale.service.GetRecommendedItems;
import com.sigwalt.itemsOnSale.service.listOfItems.SalesItems;
import com.sigwalt.itemsOnSale.service.listOfItems.UserPreferredCategoriesList;
import com.sigwalt.itemsOnSale.service.listOfItems.WishList;

@RestController
public class RecommendedListController {
	
	@Autowired
	IUserRepository userRepo;
	@Autowired
	IItemRepository itemRepo;


	@GetMapping(path = "/recommendations/{userName}")
	public ResponseEntity<Map<String, List<ItemDto>>> getRecommendations(@PathVariable String userName) {
		User user = userRepo.findByUserName(userName);
		Map<String, List<ItemDto>> recommendedItems = new GetRecommendedItems(itemRepo, Arrays.asList(new SalesItems(), new UserPreferredCategoriesList(), new WishList())).execute(user.getId());
		return  ResponseEntity.ok(recommendedItems);
	}
	
}