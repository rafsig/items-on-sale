package com.sigwalt.itemsOnSale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sigwalt.itemsOnSale.dao.ListItemsDao;
import com.sigwalt.itemsOnSale.model.User;
import com.sigwalt.itemsOnSale.repository.IItemRepository;
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

	@GetMapping(path = "/recommendations/{userName}")
	public ResponseEntity<List<ListItemsDao>> getRecommendations(@PathVariable String userName) {
		User user = userRepo.findByUserName(userName);

		return ResponseEntity.ok(ListItemsDao.convert(user.getWishList().getItemList()));
	}
	
}
