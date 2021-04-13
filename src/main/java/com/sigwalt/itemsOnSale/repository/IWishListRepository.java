package com.sigwalt.itemsOnSale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigwalt.itemsOnSale.model.WishList;

@Repository
public interface IWishListRepository extends JpaRepository<WishList, Long> {

}
