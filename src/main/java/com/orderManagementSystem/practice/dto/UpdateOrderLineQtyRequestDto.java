package com.orderManagementSystem.practice.dto;

import lombok.Data;

@Data
public class UpdateOrderLineQtyRequestDto {
    private Long id;
    private Integer quantity;
}
