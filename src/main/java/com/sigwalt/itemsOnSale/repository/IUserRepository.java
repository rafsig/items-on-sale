package com.sigwalt.itemsOnSale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigwalt.itemsOnSale.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

}
