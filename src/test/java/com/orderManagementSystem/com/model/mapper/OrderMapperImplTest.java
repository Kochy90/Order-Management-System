package com.orderManagementSystem.com.model.mapper;

import com.orderManagementSystem.com.dto.CreateOrderRequestDto;
import com.orderManagementSystem.com.model.Customer;
import com.orderManagementSystem.com.model.Order;
import com.orderManagementSystem.com.model.OrderLine;
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
