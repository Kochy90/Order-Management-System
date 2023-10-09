package com.orderManagementSystem.practice.dto;

import lombok.Data;

@Data
public class CreateProductRequestDto {
    private String name;
    private String skuCode;
    private Double unitPrice;
}
