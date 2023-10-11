package com.orderManagementSystem.practice.service;

import com.orderManagementSystem.practice.dto.CreateCustomerRequestDto;
import com.orderManagementSystem.practice.model.Customer;
import com.orderManagementSystem.practice.model.Order;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(CreateCustomerRequestDto dto);

}
