package com.shopcart.backend.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.shopcart.backend.model.Products;
import com.shopcart.backend.service.ProductsService;

@RestController	
@CrossOrigin("http://localhost:3000")
public class ProductsController {

	@Autowired
	ProductsService productsService;
	@PostMapping("products/addProduct")
	Products newProduct(@RequestBody Products products)
	{
		return productsService.addProducts(products);
	}
	
	@PutMapping("/products/updateProduct")
	Products updateProduct(@RequestBody Products product) {
		Long id = product.getProductId();
		return productsService.updateProducts(id, product);
	}
	@GetMapping("/products/getById/{productId}")
	Optional<Products> getProductById(@PathVariable("productId")Long id){
		return productsService.getProductById(id);
	}
	@GetMapping("/products/getAll")
	List<Products> getAllProducts(){
		return productsService.getAll();
	}
	@GetMapping("/products/search/{keyword}")
	List<Products> getAllBySearchString(@PathVariable("keyword")String keyword){
		return productsService.getAllByKeyword(keyword);
		
	}
	@PostMapping("/products/searchbyname/{category}")
	List<Products> getAllbyFilterName(@PathVariable("category")String category,@RequestBody ObjectNode map)
			{
				
				return productsService.getAllByFiltername(category, map);
			}
	@PostMapping("/products/searchbyprice/{category}")
	List<Products> getAllbyFilterPrice(@PathVariable("category")String category,@RequestBody ObjectNode map)
			{
				
				return productsService.getAllByFilterprice(category, map);
			}
	
	@PostMapping("/products/searchbyboth/{category}")
	List<Products> getAllbyFilter(@PathVariable("category")String category,@RequestBody ObjectNode map)
			{
				
				return productsService.getAllByFilter(category, map);
			}
	@PostMapping("/products/search/{category}")
	List<Products> getAllbyCategory(@PathVariable("category")String category)
			{
				
				return productsService.getAllByCategory(category);
			}
}
