package com.orderManagementSystem.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderLineQtyRequestDto {
    private Long orderId;
    private Long orderLineId;
    private Integer quantity;
}
