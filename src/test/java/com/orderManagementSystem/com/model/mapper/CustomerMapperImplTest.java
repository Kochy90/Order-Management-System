package com.orderManagementSystem.com.model.mapper;

import com.orderManagementSystem.com.dto.CreateCustomerRequestDto;
import com.orderManagementSystem.com.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class CustomerMapperImplTest {

    CustomerMapper mapper = new CustomerMapperImpl();

    @Test
    public void ShouldMapCreateCustomerRequestDtoToCustomer() {
        String registrationCode = "regCode";
        String fullName = "Bruce Wayne";
        String email = "batman@gotham.com";
        String telephone ="574123456";
        //given
        CreateCustomerRequestDto dto = CreateCustomerRequestDto.builder()
                .registrationCode(registrationCode)
                .fullName(fullName)
                .email(email)
                .telephone(telephone)
                .build();
        //when
        Customer customer = mapper.INSTANCE.convert(dto);
        //then
        assertEquals(customer.getFullName(), fullName);
        assertEquals(customer.getEmail(), email);
        assertEquals(customer.getTelephone(), telephone);
        assertEquals(customer.getRegistrationCode(), registrationCode);
        assertNull(customer.getId());
        assertNull(customer.getOrders());
    }

}
