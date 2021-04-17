package com.sigwalt.itemsOnSale.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String userName;
	private String email;
	private String password;
	@OneToOne(fetch = FetchType.LAZY)
	private WishList wishList;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<PlacedOrder> orderList;
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Profile> role;
	
	
	
	
	public Set<Profile> getRoles() {
		return role;
	}

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}
	
	public WishList getWishList() {
		return wishList;
	}

	public List<PlacedOrder> getOrderList() {
		return orderList;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return role;
	}

	@Override
	public String getUsername() {
		return userName;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
