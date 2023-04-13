package com.shopcart.backend.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
@DynamicInsert
@DynamicUpdate
public class Cart {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cartItemId;
	
	private Long quantity;
	private Long userId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id", referencedColumnName="productId")
	private Products products;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getCartItemId() {
		return cartItemId;
	}
	public Products getProducts() {
		return products;
	}
	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
}
