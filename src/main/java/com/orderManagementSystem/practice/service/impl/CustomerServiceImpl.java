package com.orderManagementSystem.practice.service.impl;

import com.orderManagementSystem.practice.model.Order;
import com.orderManagementSystem.practice.repository.CustomerRepository;
import com.orderManagementSystem.practice.dto.CreateCustomerRequestDto;
import com.orderManagementSystem.practice.model.Customer;
import com.orderManagementSystem.practice.model.mapper.CustomerMapper;
import com.orderManagementSystem.practice.service.CustomerService;
import com.orderManagementSystem.practice.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private final CustomerRepository repository;

    @Override
    public Customer createCustomer(CreateCustomerRequestDto dto) {
        Customer newCustomer = CustomerMapper.INSTANCE.convert(dto);
        return repository.save(newCustomer);
    }
}
