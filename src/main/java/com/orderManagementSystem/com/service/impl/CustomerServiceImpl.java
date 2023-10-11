package com.orderManagementSystem.com.service.impl;

import com.orderManagementSystem.com.repository.CustomerRepository;
import com.orderManagementSystem.com.dto.CreateCustomerRequestDto;
import com.orderManagementSystem.com.model.Customer;
import com.orderManagementSystem.com.model.mapper.CustomerMapper;
import com.orderManagementSystem.com.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
