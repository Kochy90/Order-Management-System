package com.orderManagementSystem.practice.dto;

import com.orderManagementSystem.practice.model.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddOrderLineToOrderDto {
    Long orderId;
    Product product;
    Integer quantity;
}
