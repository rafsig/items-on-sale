package com.sigwalt.itemsOnSale.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class WishList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private long id;
	@ManyToMany
	private List<Item> itemList;
	
	public long getId() {
		return id;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	
}
