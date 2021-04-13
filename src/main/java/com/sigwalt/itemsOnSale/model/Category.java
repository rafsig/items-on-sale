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
	@ManyToMany
	@Column(name = "item")
	private List<Item> itemList;
}
