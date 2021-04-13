package com.sigwalt.itemsOnSale.dto;

import java.util.List;

public class RecommendedItemsDto {
	List<ListItemsDto> wishList;
	List<ListItemsDto> saleList;
	List<ListItemsDto> categoryList;
	
	public RecommendedItemsDto(List<ListItemsDto> wishList, List<ListItemsDto> saleList,
			List<ListItemsDto> categoryList) {
		super();
		this.wishList = wishList;
		this.saleList = saleList;
		this.categoryList = categoryList;
	}

	public List<ListItemsDto> getWishList() {
		return wishList;
	}

	public List<ListItemsDto> getSaleList() {
		return saleList;
	}

	public List<ListItemsDto> getCategoryList() {
		return categoryList;
	}
	
}
