package com.orderManagementSystem.practice.service;

import com.orderManagementSystem.practice.dto.CreateProductRequestDto;
import com.orderManagementSystem.practice.model.Product;

public interface ProductService {

    Product createProduct(CreateProductRequestDto dto);

}
