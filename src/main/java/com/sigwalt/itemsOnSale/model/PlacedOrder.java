package com.sigwalt.itemsOnSale.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class PlacedOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long id;
	@ManyToOne(targetEntity = User.class)
	private User user;
	private LocalDate date;
	@ManyToMany(targetEntity = Item.class)
	private List<Item> item;
	
	public Long getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public LocalDate getDate() {
		return date;
	}
	public List<Item> getItem() {
		return item;
	}
	
	
	
}
