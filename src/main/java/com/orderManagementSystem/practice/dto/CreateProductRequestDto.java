package com.orderManagementSystem.practice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductRequestDto {
    private String name;
    private String skuCode;
    private Double unitPrice;
}
