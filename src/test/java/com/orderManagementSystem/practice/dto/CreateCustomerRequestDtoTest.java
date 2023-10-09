package com.orderManagementSystem.practice.dto;

import com.orderManagementSystem.practice.model.mapper.CustomerMapper;
import com.orderManagementSystem.practice.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateCustomerRequestDtoTest {

    @Test
    public void ShouldMapDtoToCustomer() {
        String registrationCode = "regCode";
        String fullName = "Bruce Wayne";
        String email = "batman@gotham.com";
        String telephone ="574123456";

        //given
        CreateCustomerRequestDto dto = new CreateCustomerRequestDto(registrationCode, fullName, email, telephone);

        //when
        Customer customer = CustomerMapper.INSTANCE.convert(dto);

        assertEquals(customer.getFullName(), fullName);
        assertEquals(customer.getEmail(), email);
        assertEquals(customer.getTelephone(), telephone);
        assertEquals(customer.getRegistrationCode(), registrationCode);
        assertNull(customer.getId());
        assertNull(customer.getOrders());

    }

}