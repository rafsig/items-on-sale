package com.sigwalt.itemsOnSale.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sigwalt.itemsOnSale.dto.ItemDto;
import com.sigwalt.itemsOnSale.repository.IItemRepository;
import com.sigwalt.itemsOnSale.service.listOfItems.ListOfItemsToBeRetrieved;

public class GetRecommendedItems {
	
	private List<ListOfItemsToBeRetrieved> list;
	private IItemRepository itemRepo;
	
	public GetRecommendedItems(IItemRepository itemRepo, List<ListOfItemsToBeRetrieved> list ) {
		this.list = list;
		this.itemRepo = itemRepo;
	}
	
	public Map<String, List<ItemDto>> execute(long userId) {
		Map<String, List<ItemDto>> listOfItems = new HashMap<>();
		this.list.forEach(listOfItemsToBeRetrieved -> {
			listOfItems.put(listOfItemsToBeRetrieved.getClass().getSimpleName(), listOfItemsToBeRetrieved.execute(userId, itemRepo));
		});
		return listOfItems;
		
		
	}

}
