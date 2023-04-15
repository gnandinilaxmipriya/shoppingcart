package com.shopcart.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	private Long cartitemId;
	private Long userId;
	private String orderstatus;
	private String date;
	private String time;
	private Long productId;
	private Long quantity;
public Long getProductId() {
		return productId;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTime(String time) {
		this.time = time;
	}
	//	@ManyToOne
//    @JoinColumn(name = "superOrdersId_id")
//	private SuperOrders superOrders;
//	
//	public SuperOrders getSuperOrders() {
//		return superOrders;
//	}
//	public void setSuperOrders(SuperOrders superOrders) {
//		this.superOrders = superOrders;
//	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public Long getCartitemId() {
		return cartitemId;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public void setCartitemId(Long cartitemId) {
		this.cartitemId = cartitemId;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
}
