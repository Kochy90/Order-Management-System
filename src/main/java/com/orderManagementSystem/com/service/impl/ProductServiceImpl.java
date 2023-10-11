package com.orderManagementSystem.com.service.impl;

import com.orderManagementSystem.com.exception.ProductNotFoundException;
import com.orderManagementSystem.com.repository.ProductRepository;
import com.orderManagementSystem.com.dto.CreateProductRequestDto;
import com.orderManagementSystem.com.model.Product;
import com.orderManagementSystem.com.model.mapper.ProductMapper;
import com.orderManagementSystem.com.service.ProductService;
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
