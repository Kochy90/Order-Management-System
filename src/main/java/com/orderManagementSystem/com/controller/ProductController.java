package com.orderManagementSystem.com.controller;

import com.orderManagementSystem.com.dto.CreateProductRequestDto;
import com.orderManagementSystem.com.model.Product;
import com.orderManagementSystem.com.service.OrderService;
import com.orderManagementSystem.com.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product-management")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @PostMapping("/managed-products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto requestDto) {
        Product newProduct = productService.createProduct(requestDto);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

}
