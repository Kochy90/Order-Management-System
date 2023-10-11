package com.orderManagementSystem.com.service;

import com.orderManagementSystem.com.dto.CreateCustomerRequestDto;
import com.orderManagementSystem.com.model.Customer;

public interface CustomerService {

    Customer createCustomer(CreateCustomerRequestDto dto);

}
