package com.orderManagementSystem.practice.dto;

import com.orderManagementSystem.practice.model.Customer;
import com.orderManagementSystem.practice.model.OrderLine;
import lombok.Data;

import lombok.Builder;

import java.util.List;

@Data
@Builder
public class CreateOrderRequestDto {
    private Customer customer;
    private List<OrderLine> listOfOrderLines;
}
