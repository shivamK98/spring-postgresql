package com.java.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.springboot.model.ProductDTO;

@Repository
public interface ProductRepository extends JpaRepository<ProductDTO, Long> {
	
	@Query(value = "Select p from ProductDTO p where p.productName = ?1")
	Optional<ProductDTO> findByProductName(String productName);
}
