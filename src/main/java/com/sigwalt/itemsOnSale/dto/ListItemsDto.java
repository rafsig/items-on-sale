package com.sigwalt.itemsOnSale.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.ManyToMany;

import com.sigwalt.itemsOnSale.model.Category;
import com.sigwalt.itemsOnSale.model.Item;
import com.sigwalt.itemsOnSale.model.PlacedOrder;

public class ListItemsDto {

	private long id;
	private String name;
	private BigDecimal price;
	private boolean sale;
	private BigDecimal discount = BigDecimal.ZERO;
	private int rating;
	
	public ListItemsDto(Item item) {
		this.id = item.getId();
		this.name = item.getName();
		this.price = item.getPrice();
		this.sale = item.isSale();
		this.discount = item.getDiscount();
		this.rating = item.getRating();
	}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public boolean isSale() {
		return sale;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public int getRating() {
		return rating;
	}
	
	public static List<ListItemsDto> convert(List<Item> itemsList){
		return itemsList.stream().map(ListItemsDto::new).collect(Collectors.toList());
	}

}
