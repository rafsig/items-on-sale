package com.sigwalt.itemsOnSale.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

import org.hibernate.secure.spi.GrantedPermission;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Profile implements GrantedAuthority {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	@ManyToMany(mappedBy = "role")
	private List<User> user;
	
	public List<User> getUser() {
		return user;
	}

	@Override
	public String getAuthority() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	



}
