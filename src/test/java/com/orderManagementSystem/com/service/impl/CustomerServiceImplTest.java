package com.orderManagementSystem.com.service.impl;

import com.orderManagementSystem.com.dto.CreateCustomerRequestDto;
import com.orderManagementSystem.com.model.Customer;
import com.orderManagementSystem.com.model.mapper.CustomerMapper;
import com.orderManagementSystem.com.repository.CustomerRepository;
import com.orderManagementSystem.com.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    CustomerService customerService;

    @Mock
    CustomerRepository repository;

    @Mock
    CustomerMapper mapper;

    @BeforeEach
    void setUp() {
        customerService = new CustomerServiceImpl(repository);
    }

    @Test
    void createCustomerSavesNewCustomerToRepository() {
        String fullName = "Bruce Wayne";
        String registrationCode = "IamBatman";
        String email = "batman@gotham.com";
        String telephone = "123456789";
        //given
        CreateCustomerRequestDto dto = CreateCustomerRequestDto.builder()
                .registrationCode(registrationCode)
                .fullName(fullName)
                .email(email)
                .telephone(telephone)
                .build();
        Customer newCustomer = Customer.builder()
                .registrationCode(registrationCode)
                .fullName(fullName)
                .email(email)
                .telephone(telephone).build();
        //when
        customerService.createCustomer(dto);
        //then
        verify(repository).save(newCustomer);
    }

}