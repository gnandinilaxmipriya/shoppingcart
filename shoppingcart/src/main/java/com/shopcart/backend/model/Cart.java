package com.shopcart.backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cartitemId;
	private Long userId;
	private int quantity;
	private Long productId;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="productId", referencedColumnName="productId") 
//	private Products products;

	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCartitemId() {
		return cartitemId;
	}

	public Long getUserId() {
		return userId;
	}

	public int getQuantity() {
		return quantity;
	}

//	public Products getProducts() {
//		return products;
//	}

	public void setCartitemId(Long cartitemId) {
		this.cartitemId = cartitemId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//	public void setProducts(Products products) {
//		this.products = products;
//	}

}
