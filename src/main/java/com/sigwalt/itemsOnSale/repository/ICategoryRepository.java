package com.sigwalt.itemsOnSale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sigwalt.itemsOnSale.model.Category;
import com.sigwalt.itemsOnSale.model.Item;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
