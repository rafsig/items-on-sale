package com.sigwalt.itemsOnSale.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class WishList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long id;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Item> itemList;
	@OneToOne(mappedBy = "wishList")
	private User user;
	
	public Long getId() {
		return id;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	
}
