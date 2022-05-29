package com.java.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
//	get product by id
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getSingleProduct(@PathVariable("id") Long id){
		Optional<ProductDTO> productOptional = productRepository.findById(id);
		if(productOptional.isPresent()) {
			return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Product not found with id " + id, HttpStatus.NOT_FOUND);					
		}
	}
	
//	update a product
	@PutMapping("/product/{id}")
	public ResponseEntity<?> putById(@PathVariable("id") Long id, @RequestBody ProductDTO productNew){
		Optional<ProductDTO> productOptional = productRepository.findById(id);
		if(productOptional.isPresent()) {
			ProductDTO productSave = productOptional.get();
			productSave.setProductName(productNew.getProductName() == null ? productSave.getProductName() : productNew.getProductName());
			productSave.setPrice(productNew.getPrice() == 0 ? productSave.getPrice() : productNew.getPrice());
			productRepository.save(productSave);
			return new ResponseEntity<>(productSave, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Product not found with id " + id, HttpStatus.NOT_FOUND);
		}
	}
	
//	delete a product
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		try {
			productRepository.deleteById(id);
			return new ResponseEntity<>("Product with id "+ id + " successfully deleted!", HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}













