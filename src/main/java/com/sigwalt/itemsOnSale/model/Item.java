package com.sigwalt.itemsOnSale.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private long id;
	private String name;
	private BigDecimal price;
	private boolean sale;
	private BigDecimal discount = BigDecimal.ZERO;
	private int rating;
	@ManyToMany
	private List<Category> category;
	@ManyToMany(targetEntity = Order.class, mappedBy = "item")
	private List<Order> order;
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
	public List<Category> getCategory() {
		return category;
	}
	public List<Order> getOrder() {
		return order;
	}
	
	

}
