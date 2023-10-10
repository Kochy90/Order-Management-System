package com.orderManagementSystem.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderLineQtyRequestDto {
    private Long id;
    private Integer quantity;
}
