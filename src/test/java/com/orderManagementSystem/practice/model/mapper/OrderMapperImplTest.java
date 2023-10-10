package com.orderManagementSystem.practice.model.mapper;

import com.orderManagementSystem.practice.dto.CreateOrderRequestDto;
import com.orderManagementSystem.practice.model.Customer;
import com.orderManagementSystem.practice.model.Order;
import com.orderManagementSystem.practice.model.OrderLine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class OrderMapperImplTest {

    OrderMapper mapper = new OrderMapperImpl();

    @Test
    public void ShouldMapCreateOrderRequestDtoToCustomer() {
        Customer customer = Customer.builder().id(3L).build();
        List<OrderLine> orderLines = List.of(new OrderLine());

        //given
        CreateOrderRequestDto dto = CreateOrderRequestDto.builder()
                .customer(customer)
                .listOfOrderLines(orderLines)
                .build();
        //when
        Order order = mapper.INSTANCE.convert(dto);
        //then
        assertEquals(order.getCustomer(), customer);
        assertEquals(order.getListOfOrderLines(), orderLines);
        assertNull(order.getId());
    }
}
