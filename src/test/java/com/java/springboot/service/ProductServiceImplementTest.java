package com.java.springboot.service;

import com.java.springboot.exception.ProductExistException;
import com.java.springboot.model.ProductDTO;
import com.java.springboot.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplementTest {

    @Mock
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImplement productServiceImplement;

    ProductDTO product;

    @BeforeEach
    void setUp() {

        this.productServiceImplement = new ProductServiceImplement(productRepository);
        this.product = new ProductDTO("Battery", 125);
    }

    @Test
    void createProduct() {

        try{
            productServiceImplement.createProduct(this.product);
        }catch (Exception e){
            assertThat(e)
                    .isInstanceOf(ProductExistException.class)
                    .hasMessage("Product with given name already exist");
        }
    }
}