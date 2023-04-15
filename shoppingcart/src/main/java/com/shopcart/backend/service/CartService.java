package com.shopcart.backend.service;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	public List<Object> getProductsofUserId(Long userId){
		List<Cart> cart = cartRepository.findByUserId(userId);
		List<Object> l = new ArrayList<>();
		
		for(Cart c: cart) {
			Optional<Products> products = productsRepository.findById(c.getProductId());
//			List<String> l2 = new ArrayList<>();
			HashMap<String,String> l2 = new HashMap<String,String>();
			l2.put("category",products.get().getCategory());
			l2.put("details",products.get().getDetails());
			l2.put("filepath",products.get().getFilepath());
			l2.put("name",products.get().getName());
			l2.put("price",products.get().getPrice());
			l2.put("productId",products.get().getProductId().toString());
			
			l2.put("cartitemId",c.getCartitemId().toString());
			l2.put("quantity",String.valueOf(c.getQuantity()));
			l2.put("userId",c.getUserId().toString());
			l.add(l2);
		}
		return l;
	}
	public HashMap<Long,Long> getTotalPrice(Long userId){
		List<Cart> cart = cartRepository.findByUserId(userId);
		HashMap<Long,Long>  map = new HashMap<Long,Long>();
//		HashMap<Long,HashMap<String,Integer>> hm2= new HashMap<Long,HashMap<String,Integer>>();
		Long quantity;
		Long price;
		List<Products> productlist= new ArrayList<>();
		for(Cart c: cart) {
			Optional<Products> products = productsRepository.findById(c.getProductId());
			productlist.add(products.get());
			price=(long) Integer.parseInt(products.get().getPrice());
			quantity =  (long) c.getQuantity();
			map.put(c.getProductId(), price*quantity);
		}
		
		
		return map;
	}
	
////	public List<List<String>> getProductquantityfororder(Long userId){
////		List<List<String>> l = new ArrayList<List<String>>();
////		List<Cart> cart = cartRepository.findByUserId(userId);
////		Long cartitemId;
////		Long quantity;
////		Long productId;
////		String name;
////		Long category;
////		
////		if(!cart.isEmpty()) {
////			for(Cart c : cart) {
////				
////			}
////		}
//		
//		return null;
//		
//	}
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
