package com.orderManagementSystem.practice.service.impl;

import com.orderManagementSystem.practice.dto.CreateOrderRequestDto;
import com.orderManagementSystem.practice.model.Customer;
import com.orderManagementSystem.practice.model.Order;
import com.orderManagementSystem.practice.model.OrderLine;
import com.orderManagementSystem.practice.model.Product;
import com.orderManagementSystem.practice.repository.OrderRepository;
import com.orderManagementSystem.practice.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    OrderService orderService;

    @Mock
    OrderRepository repository;

    @BeforeEach
    void setUp() {
        orderService = new OrderServiceImpl(repository);
    }

    @Test
    void createOrderSavesNewOrderToRepository() {
        Customer customer = Customer.builder().id(3L).build();
        List<OrderLine> orderLines = List.of(new OrderLine());

        CreateOrderRequestDto dto = CreateOrderRequestDto.builder().customer(customer).listOfOrderLines(orderLines).build();
        Order newOrder = Order.builder().customer(customer).listOfOrderLines(orderLines).build();

        orderService.createOrder(dto);

        verify(repository).save(newOrder);
    }

    @Test
    void getOrderByCustomerCallsCorrectRepositoryMethod() {
        Customer customer = new Customer();
        orderService.getOrderByCustomer(customer);
        verify(repository).findOrderByCustomer(customer);
    }

    @Test
    void getOrdersByDateCallsCorrectRepositoryMethod() {
        Date date = new Date();
        orderService.getOrdersByDate(date);
        verify(repository).findOrdersBySubmissionDate(date);
    }

    @Test
    void getOrdersByProductCallsCorrectRepositoryMethod() {
        Product product = Product.builder().id(1L).build();
        orderService.getOrdersByProduct(product);
        verify(repository).findOrdersByProductId(product.getId());
    }

    @Test
    void getOrdersByCustomerCallsCorrectRepositoryMethod() {
        Customer customer = new Customer();
        orderService.getOrdersByCustomer(customer);
        verify(repository).findOrdersByCustomer(customer);
    }

}