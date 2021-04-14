package com.sigwalt.itemsOnSale.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String userName;
	private String email;
	private String password;
	@OneToOne(fetch = FetchType.LAZY)
	private WishList wishList;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<PlacedOrder> orderList;
	
	
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

	
	public WishList getWishList() {
		return wishList;
	}

	public List<PlacedOrder> getOrderList() {
		return orderList;
	}
	
}
