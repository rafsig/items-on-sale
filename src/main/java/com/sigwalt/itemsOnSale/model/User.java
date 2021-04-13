package com.sigwalt.itemsOnSale.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String userName;
	private String email;
	private String password;
	@OneToOne
	private WishList wishList;
	@OneToMany
	private List<Order> orderList;
	
	
	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public WishList getWishList() {
		return wishList;
	}

	
}
