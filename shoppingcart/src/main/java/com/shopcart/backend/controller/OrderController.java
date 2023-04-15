package com.shopcart.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopcart.backend.model.Orders;
import com.shopcart.backend.service.OrderService;

@RestController
@CrossOrigin("http://localhost:3000")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order/{userId}/createOrder")
	public Orders addOrder(@RequestBody Orders order) {
		return orderService.addtoorder(order);
	}
	
	@GetMapping("/getOrders")
	public List<Orders> getAllOrders(){
		return orderService.getOrderedItems();
	}
	@GetMapping("/cart/getOrdersTime/{userId}")
	public List<Orders> getAllOrdersByTime(@PathVariable("userId")Long userId){
		return orderService.getOrderedItemsByTime(userId);
	}
}
