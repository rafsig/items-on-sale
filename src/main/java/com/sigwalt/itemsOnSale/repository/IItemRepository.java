package com.sigwalt.itemsOnSale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigwalt.itemsOnSale.model.Category;
import com.sigwalt.itemsOnSale.model.Item;
import com.sigwalt.itemsOnSale.model.PlacedOrder;
import com.sigwalt.itemsOnSale.model.User;
import com.sigwalt.itemsOnSale.model.WishList;

@Repository
public interface IItemRepository extends JpaRepository<Item, Long> {

	List<Item> getItemsBySaleOrderByRatingDesc(boolean sale);	
	
	@Query("select distinct j from PlacedOrder o Join o.item i Join o.user u on u.id = :userId Join i.category c Join c.itemList j order by j.rating desc")
	List<Item> getItemsByCategoryByOrderByUser(Long userId);
	
}
