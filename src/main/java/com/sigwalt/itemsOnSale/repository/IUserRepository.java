package com.sigwalt.itemsOnSale.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigwalt.itemsOnSale.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserName(String userName);

}
