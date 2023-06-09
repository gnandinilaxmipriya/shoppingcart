package com.shopcart.backend.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
@DynamicInsert
@DynamicUpdate
public class Products {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;
	
	private String name;
	private String price;
	private String details;
	private String category;
	private String[] subcategory;
//	@Lob
//	@Basic(fetch = FetchType.LAZY)
	@Column(name = "filepath", columnDefinition = "text")
	@Lob
	private String filepath;
	public Long getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public String getPrice() {
		return price;
	}
	public String getDetails() {
		return details;
	}
	public String getCategory() {
		return category;
	}
	public String[] getSubcategory() {
		return subcategory;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setSubcategory(String[] subcategory) {
		this.subcategory = subcategory;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	
	

}
