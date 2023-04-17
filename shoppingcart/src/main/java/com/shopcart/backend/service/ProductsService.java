package com.shopcart.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.shopcart.backend.model.Products;
import com.shopcart.backend.repository.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository productsRepository;

	public Products addProducts(Products products) {
		
		return productsRepository.save(products);
	}
	public Products updateProducts(Long id,Products products)
	{
		Products existingProduct = productsRepository.findById(id).get();
		existingProduct.setName(products.getName());
		existingProduct.setPrice(products.getPrice());
		existingProduct.setDetails(products.getDetails());
		existingProduct.setCategory(products.getCategory());
		existingProduct.setSubcategory(products.getSubcategory());
		existingProduct.setFilepath(products.getFilepath());
		return productsRepository.save(existingProduct);
	}
	
	public Optional<Products> getProductById(Long id){
		return productsRepository.findById(id);
	}
	
	public List<Products> getAll()
	{
		return productsRepository.findAll();
	}
	public List<Products> getAllByKeyword(String keyword){
		return productsRepository.findAll(keyword);
	}
	public List<Products> getAllByFiltername(String category,ObjectNode map){
		String keyword = map.get("name").asText();
		return productsRepository.findAllByFilterName(category, keyword);
		
		
	}
	public List<Products> getAllByFilterprice(String category,ObjectNode map){
		String keyword = map.get("price").asText();
		return productsRepository.findAllByFilterPrice(category, keyword);
		
	}
	
	public List<Products> getAllByFilter(String category,ObjectNode map){
		String name = map.get("name").asText();
		String price = map.get("price").asText();
		return productsRepository.findAllByFilter(category, name, price);
		
	}
	public List<Products> getAllByCategory(String category){
		
		return productsRepository.findAllByCategory(category);
		
	}
}

