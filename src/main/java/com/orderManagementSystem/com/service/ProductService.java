package com.orderManagementSystem.com.service;

import com.orderManagementSystem.com.dto.CreateProductRequestDto;
import com.orderManagementSystem.com.exception.ProductNotFoundException;
import com.orderManagementSystem.com.model.Product;

public interface ProductService {

    Product createProduct(CreateProductRequestDto dto);
    Product getProductById(Long productId) throws ProductNotFoundException;

}
