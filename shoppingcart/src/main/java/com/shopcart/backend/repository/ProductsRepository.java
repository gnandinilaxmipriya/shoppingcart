package com.shopcart.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopcart.backend.model.Products;

public interface ProductsRepository extends JpaRepository<Products,Long>{

	@Query("SELECT p FROM Products p WHERE "+"CONCAT(p.name, p.details, p.category, p.price)"+" LIKE %?1%")
	public List<Products> findAll(String keyword);
	
	@Query("SELECT p FROM Products p where p.category=?1"+" or (p.name LIKE %?2%)"+" or (p.price LIKE %?3%)")
	public List<Products> findAllByFilter(String category,String name,String price);
	
	@Query("SELECT p FROM Products p where p.category=?1"+" AND (p.name LIKE %?2%)")
	public List<Products> findAllByFilterName(String category,String keyword);
	
	@Query("SELECT p FROM Products p where p.category=?1"+" AND (p.price LIKE %?2%)")
	public List<Products> findAllByFilterPrice(String category,String keyword);
	
	@Query("SELECT p FROM Products p WHERE p.category LIKE %?1% ORDER BY p.price")
	public List<Products> findAllByCategory(String category);
	
}
