package com.sigwalt.itemsOnSale.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "PLACED_ORDER")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private long id;
	@ManyToOne(targetEntity = User.class)
	private User user;
	private LocalDate date;
	@ManyToMany(targetEntity = Item.class)
	private List<Item> item;
	
}