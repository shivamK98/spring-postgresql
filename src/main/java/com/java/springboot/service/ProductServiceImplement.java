package com.java.springboot.service;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.exception.ProductExistException;
import com.java.springboot.model.ProductDTO;
import com.java.springboot.repository.ProductRepository;

@Service
public class ProductServiceImplement implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public ProductServiceImplement() {
	}

	public ProductServiceImplement(ProductRepository productRepository) {

		this.productRepository = productRepository;
	}

	@Override
	public void createProduct(ProductDTO product) throws ProductExistException, ConstraintViolationException {
		
		Optional<ProductDTO> productOptional = productRepository.findByProductName(product.getProductName());
		if(productOptional.isPresent()) {
			throw new ProductExistException(ProductExistException.ProductAlreadyExist());
		}else {
			productRepository.save(product);
		}
	}

}
