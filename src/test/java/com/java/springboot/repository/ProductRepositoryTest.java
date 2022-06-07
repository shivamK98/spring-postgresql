package com.java.springboot.repository;

import com.java.springboot.model.ProductDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    ProductDTO product;

    @BeforeEach
    void setUp() {

        this.product = new ProductDTO("Battery", 125);
        productRepository.save(product);
    }

    @AfterEach
    public void tearDown() {
        productRepository.deleteById(product.getId());
    }

    @Test
    void findByProductName() {

        Optional<ProductDTO> actualProduct = productRepository.findByProductName("Battery");
        assertThat(actualProduct.isPresent()).isTrue();
    }

}