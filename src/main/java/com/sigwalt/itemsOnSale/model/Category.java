package com.sigwalt.itemsOnSale.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private long id;
	private String name;
	@ManyToMany(mappedBy = "category")
	@Column(name = "item")
	private List<Item> itemList;
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	
	
}
