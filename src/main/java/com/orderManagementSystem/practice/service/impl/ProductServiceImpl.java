package com.orderManagementSystem.practice.service.impl;

import com.orderManagementSystem.practice.exception.ProductNotFoundException;
import com.orderManagementSystem.practice.repository.ProductRepository;
import com.orderManagementSystem.practice.dto.CreateProductRequestDto;
import com.orderManagementSystem.practice.model.Product;
import com.orderManagementSystem.practice.model.mapper.ProductMapper;
import com.orderManagementSystem.practice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository repository;

    @Override
    public Product createProduct(CreateProductRequestDto dto) {
        Product newProduct = ProductMapper.INSTANCE.convert(dto);
        return repository.save(newProduct);
    }

    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        return repository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);
    }
}
