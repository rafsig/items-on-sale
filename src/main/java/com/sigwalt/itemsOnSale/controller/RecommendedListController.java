package com.sigwalt.itemsOnSale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sigwalt.itemsOnSale.dto.ListItemsDto;
import com.sigwalt.itemsOnSale.dto.RecommendedItemsDto;
import com.sigwalt.itemsOnSale.model.Category;
import com.sigwalt.itemsOnSale.model.Item;
import com.sigwalt.itemsOnSale.model.User;
import com.sigwalt.itemsOnSale.repository.ICategoryRepository;
import com.sigwalt.itemsOnSale.repository.IItemRepository;
import com.sigwalt.itemsOnSale.repository.IOrderRepository;
import com.sigwalt.itemsOnSale.repository.IUserRepository;
import com.sigwalt.itemsOnSale.repository.IWishListRepository;

@RestController
public class RecommendedListController {
	
	@Autowired
	IUserRepository userRepo;
	@Autowired
	IWishListRepository wishListRepo;
	@Autowired
	IItemRepository itemRepo;
	@Autowired
	IOrderRepository orderRepo;
	@Autowired
	ICategoryRepository categoryRepo;

	@GetMapping(path = "/recommendations/{userName}")
	public ResponseEntity<RecommendedItemsDto> getRecommendations(@PathVariable String userName) {
		User user = userRepo.findByUserName(userName);
		List<ListItemsDto> wishList = ListItemsDto.convert(user.getWishList().getItemList());
		List<ListItemsDto> salesItemsList = ListItemsDto.convert(itemRepo.getItemsBySaleOrderByRatingDesc(true));
		List<ListItemsDto> categoryList = ListItemsDto.convert(itemRepo.getItemsByCategoryByOrderByUser(user.getId()));
		return ResponseEntity.ok(new RecommendedItemsDto(wishList, salesItemsList, categoryList));
	}
	
}