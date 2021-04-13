package com.sigwalt.itemsOnSale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigwalt.itemsOnSale.model.WishList;

public interface IWishListRepository extends JpaRepository<WishList, Long> {

}
