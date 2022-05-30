package com.java.springboot.service;

import javax.validation.ConstraintViolationException;

import com.java.springboot.exception.ProductExistException;
import com.java.springboot.model.ProductDTO;

public interface ProductService {
	public void createProduct(ProductDTO product) throws ProductExistException, ConstraintViolationException;
}
