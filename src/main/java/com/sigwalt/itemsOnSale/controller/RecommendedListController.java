package com.sigwalt.itemsOnSale.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sigwalt.itemsOnSale.dto.ItemDto;
import com.sigwalt.itemsOnSale.model.User;
import com.sigwalt.itemsOnSale.repository.IItemRepository;
import com.sigwalt.itemsOnSale.repository.IUserRepository;
import com.sigwalt.itemsOnSale.service.GetRecommendedItems;
import com.sigwalt.itemsOnSale.service.GetRecommendedItemsHandler;
import com.sigwalt.itemsOnSale.service.listOfItems.HotDeals;
import com.sigwalt.itemsOnSale.service.listOfItems.ItemsFormIntestCategories;
import com.sigwalt.itemsOnSale.service.listOfItems.WishList;

@RestController
@RequestMapping("/recommendations")
public class RecommendedListController {
	
	@Autowired
	IUserRepository userRepo;
	@Autowired
	IItemRepository itemRepo;


	@GetMapping(path = "/{userId}")
	public ResponseEntity<Map<String, Page<ItemDto>>> getRecommendations(@PathVariable Long userId,@PageableDefault(page=0, size=Integer.MAX_VALUE, sort="rating", direction=Direction.DESC) Pageable pagination) {
		Optional<User> userOptional = userRepo.findById(userId);
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			GetRecommendedItems getRecommendedItems = new GetRecommendedItems(this.itemRepo, pagination);
			Map<String, Page<ItemDto>> recommendedItems = new GetRecommendedItemsHandler(getRecommendedItems, Arrays.asList(new HotDeals(), new ItemsFormIntestCategories(), new WishList())).execute(user.getId());
			return  ResponseEntity.ok(recommendedItems);
		}
		
		return null;
	}
	
}