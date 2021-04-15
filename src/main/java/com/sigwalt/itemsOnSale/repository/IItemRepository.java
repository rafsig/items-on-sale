package com.sigwalt.itemsOnSale.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sigwalt.itemsOnSale.model.Item;

@Repository
public interface IItemRepository extends JpaRepository<Item, Long> {

	@Cacheable(value = "salesList")
	Page<Item> getItemsBySale(boolean sale, Pageable pagination);
	
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

	//TODO fix this select statement now it is getting only bought items and should get items from the same category
	@Query("select distinct i from Item i join i.category c where i.sale = true and c.id IN (Select c.id from User u join u.orderList o join o.item i join i.category c where u.id=:userId)")
	Page<Item> getItemsByCategoryByOrderByUser(Long userId, Pageable pagination);
	
	@Query("select i from Item i join i.wishList w join w.user u where u.id = :userId ")
	Page<Item> getItemsByWishListByUser(Long userId, Pageable pagination);
	
}
