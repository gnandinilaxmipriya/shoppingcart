package com.shopcart.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopcart.backend.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}
