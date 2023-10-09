package com.orderManagementSystem.practice.service;

import com.orderManagementSystem.practice.dto.CreateCustomerRequestDto;
import com.orderManagementSystem.practice.model.Customer;

public interface CustomerService {

    Customer createCustomer(CreateCustomerRequestDto dto);

}
