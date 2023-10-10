package com.orderManagementSystem.practice.service.impl;

import com.orderManagementSystem.practice.dto.CreateProductRequestDto;
import com.orderManagementSystem.practice.model.Product;
import com.orderManagementSystem.practice.model.mapper.ProductMapper;
import com.orderManagementSystem.practice.model.mapper.ProductMapperImpl;
import com.orderManagementSystem.practice.repository.ProductRepository;
import com.orderManagementSystem.practice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    ProductService productService;

    @Mock
    ProductRepository repository;

    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl(repository);
    }

    @Test
    void createProductSavesNewProductToRepository() {
        String name = "batmobile";
        String skuCode = "nanananananananabatman";
        Double unitPrice = 1_000_000d;

        CreateProductRequestDto dto = CreateProductRequestDto.builder()
                .name(name)
                .skuCode(skuCode)
                .unitPrice(unitPrice)
                .build();
        Product newProduct = Product.builder().name(name).skuCode(skuCode).unitPrice(unitPrice).build();

        productService.createProduct(dto);

        verify(repository).save(newProduct);
    }

}