package com.sigwalt.itemsOnSale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigwalt.itemsOnSale.model.Item;

public interface IItemRepository extends JpaRepository<Item, Long> {

}
