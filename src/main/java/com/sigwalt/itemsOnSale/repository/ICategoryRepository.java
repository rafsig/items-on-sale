package com.sigwalt.itemsOnSale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigwalt.itemsOnSale.model.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
