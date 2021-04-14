package com.sigwalt.itemsOnSale.dto;

import java.util.List;

public class RecommendedItemsDto {
	List<ItemDto> wishList;
	List<ItemDto> saleList;
	List<ItemDto> categoryList;
	
	public RecommendedItemsDto(List<ItemDto> wishList, List<ItemDto> saleList,
			List<ItemDto> categoryList) {
		super();
		this.wishList = wishList;
		this.saleList = saleList;
		this.categoryList = categoryList;
	}

	public List<ItemDto> getWishList() {
		return wishList;
	}

	public List<ItemDto> getSaleList() {
		return saleList;
	}

	public List<ItemDto> getCategoryList() {
		return categoryList;
	}
	
}
