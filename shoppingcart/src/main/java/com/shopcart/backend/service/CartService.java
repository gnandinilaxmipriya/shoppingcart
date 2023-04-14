package com.shopcart.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopcart.backend.model.Cart;
import com.shopcart.backend.model.Products;
import com.shopcart.backend.repository.CartRepository;
import com.shopcart.backend.repository.ProductsRepository;

@Service
@Transactional
public class CartService {
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	public Cart addCart(Cart cart) {
		return cartRepository.save(cart);
	}
	public Cart putCart(Cart cart) {
		//String res="false";
		if(cart.getCartitemId() == null) {
			return cartRepository.save(cart);
//			res="true";
//			return res;
		}else
		{
			Optional<Cart> existingcart = cartRepository.findById(cart.getCartitemId());
			existingcart.get().setQuantity(cart.getQuantity()+1);
			return cartRepository.save(existingcart.get());
//			res="true";
//			return res;
		}
		
	}
	public Cart deleteCart(Cart cart) {
		//String res="false";
		if(cart.getCartitemId() == null) {
			return cartRepository.save(cart);
//			res="true";
//			return res;
		}else
		{
			Optional<Cart> existingcart = cartRepository.findById(cart.getCartitemId());
			existingcart.get().setQuantity(cart.getQuantity()-1);
			return cartRepository.save(existingcart.get());
//			res="true";
//			return res;
		}
		
	}
	public List<Cart> getAllCartUserId(Long userId){
		return cartRepository.findByUserId(userId);
	}
	public List<Object> getCartItems(Long userId,Long cartItemId,Long productId) {
//		Optional<Cart> cart = cartRepository.findById(cartItemId);
		Optional<Cart> cart = cartRepository.findByCartitemIdAndUserId(cartItemId, userId);
		List<Object> l = new ArrayList<>();
		l.add(cart);
		Optional<Products> products = productsRepository.findById(productId);
		l.add(products);
		return l;
	}
	
	public List<String> getCartitemid(Long productId,Long userId) {
//		List<Cart> existingcart = cartRepository.findByProductId(ProductId);
		List<Cart> existingcart = cartRepository.findByProductIdAndUserId(productId,userId);
		List<String> list = new ArrayList<String>();
		if(existingcart.isEmpty()) {
			list.add("empty");
			return list;
		}else {
			String cartitemid = existingcart.get(0).getCartitemId().toString();
			String quantity =String.valueOf(existingcart.get(0).getQuantity());
			list.add(cartitemid);
			list.add(quantity);
			return list;
		}
	}
	
	
	public void deleteCartItem(Long productId,Long userId) {
		cartRepository.deleteByProductIdAndUserId(productId, userId);
		
		
	}
	public void deleteAllCartItems(Long userId) {
		cartRepository.deleteByUserId(userId);
	}

}
