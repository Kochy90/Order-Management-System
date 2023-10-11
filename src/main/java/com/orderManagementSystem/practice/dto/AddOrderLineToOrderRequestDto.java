package com.orderManagementSystem.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddOrderLineToOrderRequestDto {
    Long orderId;
    Long productId;
    Integer quantity;
}
