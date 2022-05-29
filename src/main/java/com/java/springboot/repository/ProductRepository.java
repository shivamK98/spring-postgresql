package com.java.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.model.ProductDTO;

@Repository
public interface ProductRepository extends JpaRepository<ProductDTO, Long> {
	
}
