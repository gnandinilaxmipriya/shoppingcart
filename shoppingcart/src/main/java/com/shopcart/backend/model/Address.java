package com.shopcart.backend.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@DynamicInsert
@DynamicUpdate
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
//	@OneToOne(mappedBy = "address")
//    private Users users;
	private String street;
	private String city;
	private String state;
	private String pincode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public Users getUsers() {
//		return users;
//	}
//	public void setUsers(Users users) {
//		this.users = users;
//	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
