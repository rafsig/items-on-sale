package com.sigwalt.itemsOnSale.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sigwalt.itemsOnSale.dto.ItemDto;
import com.sigwalt.itemsOnSale.repository.IItemRepository;
import com.sigwalt.itemsOnSale.service.listOfItems.ListOfItemsToBeRetrieved;

public class GetRecommendedItemsHandler {
	
	private List<ListOfItemsToBeRetrieved> list;
	private GetRecommendedItems recommendedItems;

	
	public GetRecommendedItemsHandler(GetRecommendedItems recommendedItems, List<ListOfItemsToBeRetrieved> list ) {
		this.list = list;
		this.recommendedItems = recommendedItems;
	}
	
	//Returns a map with 3 lists one for the wishList, one for the previously bought categories and one for sale items
	public Map<String, Page<ItemDto>> execute(long userId) {
		Map<String, Page<ItemDto>> listOfItems = new HashMap<>();
		this.list.forEach(listOfItemsToBeRetrieved -> {
			listOfItems.put(listOfItemsToBeRetrieved.getClass().getSimpleName(), listOfItemsToBeRetrieved.execute(userId, recommendedItems.getItemRepository(), recommendedItems.getPagination()));
		});
		return listOfItems;
	}

}
