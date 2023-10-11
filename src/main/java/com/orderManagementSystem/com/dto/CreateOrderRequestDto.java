package com.orderManagementSystem.com.dto;

import com.orderManagementSystem.com.model.Customer;
import com.orderManagementSystem.com.model.OrderLine;
import lombok.Data;

import lombok.Builder;

import java.util.List;

@Data
@Builder
public class CreateOrderRequestDto {
    private Customer customer;
    private List<OrderLine> listOfOrderLines;
}
