package com.sigwalt.itemsOnSale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigwalt.itemsOnSale.model.PlacedOrder;

@Repository
public interface IOrderRepository extends JpaRepository<PlacedOrder, Long> {
	
}
