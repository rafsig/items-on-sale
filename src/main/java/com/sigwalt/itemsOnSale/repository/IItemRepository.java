package com.sigwalt.itemsOnSale.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigwalt.itemsOnSale.model.Item;

@Repository
public interface IItemRepository extends JpaRepository<Item, Long> {

	@Cacheable(value = "salesList")
	List<Item> getItemsBySaleOrderByRatingDesc(boolean sale);
	
	@Override
	@CacheEvict(value = "salesList")
	default <S extends Item> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@CacheEvict(value = "salesList")
	default <S extends Item> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Query("select distinct j from PlacedOrder o Join o.item i Join o.user u on u.id = :userId Join i.category c Join c.itemList j where j.sale = true order by j.rating desc ")
	List<Item> getItemsByCategoryByOrderByUser(Long userId);
	
	@Query("select i from User u Join u.wishList w Join w.itemList i where u.id = :userId and i.sale = true order by i.rating desc ")
	List<Item> getItemsByWishListByUser(Long userId);
	
}
