package com.shopcart.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopcart.backend.model.Orders;

public interface OrderRepository extends JpaRepository<Orders,Long>{

	 public List<Orders> findAllByOrderByOrderIdAsc();
	 public List<Orders> findAllByOrderByTimeDesc();
//	 public List<Orders> findByUserIdByOrderByTimeDesc(Long userId);
//	 public List<Orders> findByUserId();
	public List<Orders> findByUserId(Long userId);
	
	@Query("FROM Orders WHERE userId = ?1 ORDER BY date,time DESC")
	List<Orders> findByUserIdOrderByTimeDesc(Long userId);
}
