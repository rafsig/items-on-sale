package com.sigwalt.itemsOnSale.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionMessage.ItemsBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigwalt.itemsOnSale.model.Item;
import com.sigwalt.itemsOnSale.model.PlacedOrder;
import com.sigwalt.itemsOnSale.model.User;

@Repository
public interface IOrderRepository extends JpaRepository<PlacedOrder, Long> {
	
}
