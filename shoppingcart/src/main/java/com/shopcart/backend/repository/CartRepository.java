package com.shopcart.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopcart.backend.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>{

	public List<Cart> findByProductId(Long productId);
	public Optional<Cart> findByCartitemIdAndUserId(Long cartitemId,Long userId);
	public List<Cart> findByProductIdAndUserId(Long productId,Long userId);
	public List<Cart> findByUserId(Long userId);
	public void deleteByProductIdAndUserId(Long productId,Long userId);
	public void deleteByUserId(Long userId);
}
