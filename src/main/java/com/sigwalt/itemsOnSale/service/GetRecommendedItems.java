package com.sigwalt.itemsOnSale.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.sigwalt.itemsOnSale.model.Item;
import com.sigwalt.itemsOnSale.repository.IItemRepository;

public class GetRecommendedItems {
	
	private IItemRepository itemRepository;
	private Pageable pagination;
	
	public GetRecommendedItems(IItemRepository itemRepository, Pageable pagination) {
		super();
		this.itemRepository = itemRepository;
		this.pagination = pagination;
	}
	
	public IItemRepository getItemRepository() {
		return itemRepository;
	}
	
	public Pageable getPagination() {
		return pagination;
	}

}
