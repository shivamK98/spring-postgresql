package com.java.springboot.repository;

import com.java.springboot.model.ProductDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByProductName() {

        ProductDTO product = new ProductDTO("Battery", 125);
        productRepository.save(product);

        Optional<ProductDTO> actualProduct = productRepository.findByProductName("Battery");
        assertThat(actualProduct.isPresent()).isTrue();

        productRepository.deleteById(product.getId());
    }

}