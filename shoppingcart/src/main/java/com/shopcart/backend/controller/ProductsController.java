package com.shopcart.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
