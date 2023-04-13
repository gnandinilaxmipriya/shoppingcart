package com.shopcart.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopcart.backend.model.Cart;
import com.shopcart.backend.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	public Cart addTOCart(Cart cart) {
		return cartRepository.save(cart);
	}
	public List<Cart> getAll(){
		return cartRepository.findAll();
	}
}
