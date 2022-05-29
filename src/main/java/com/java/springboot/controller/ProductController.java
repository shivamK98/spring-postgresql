package com.java.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.repository.ProductRepository;
import com.java.springboot.model.ProductDTO;


@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
//	get products
	@GetMapping("/product")
	public List<ProductDTO> getAllProducts(){
		return this.productRepository.findAll();
	}
	
//	post products
	@PostMapping("/product")
	public ProductDTO createProduct(@RequestBody ProductDTO product){
		return this.productRepository.save(product);
	}
	
}













