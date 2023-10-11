package com.orderManagementSystem.com.service.impl;

import com.orderManagementSystem.com.dto.AddOrderLineToOrderRequestDto;
import com.orderManagementSystem.com.dto.CreateOrderRequestDto;
import com.orderManagementSystem.com.dto.UpdateOrderLineQtyRequestDto;
import com.orderManagementSystem.com.exception.OrderLineNotFoundException;
import com.orderManagementSystem.com.exception.OrderNotFoundException;
import com.orderManagementSystem.com.exception.ProductNotFoundException;
import com.orderManagementSystem.com.model.Customer;
import com.orderManagementSystem.com.model.Order;
import com.orderManagementSystem.com.model.OrderLine;
import com.orderManagementSystem.com.model.Product;
import com.orderManagementSystem.com.repository.OrderRepository;
import com.orderManagementSystem.com.service.OrderService;
import com.orderManagementSystem.com.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    OrderService orderService;

    @Mock
    OrderRepository repository;

    @Mock
    ProductService productService;

    @BeforeEach
    void setUp() {
        orderService = new OrderServiceImpl(repository, productService);
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
    void getOrdersByCustomerIdCallsCorrectRepositoryMethod() {
        Long cstId = 1L;
        orderService.getOrdersByCustomerId(cstId);
        verify(repository).findOrdersByCustomerId(cstId);
    }

    @Test
    void getOrdersByDateCallsCorrectRepositoryMethod() {
        Date date = new Date();
        orderService.getOrdersByDate(date);
        verify(repository).findOrdersBySubmissionDate(date);
    }

    @Test
    void getOrdersByProductIdCallsCorrectRepositoryMethod() {
        Long prodId = 2L;
        orderService.getOrdersByProductId(prodId);
        verify(repository).findOrdersByProductId(prodId);
    }

    @Test
    void updateNumberOfProductsInOrderLineCallsCorrectMethodsAndUpdatesQtyOfProductsCorrectly() throws OrderNotFoundException, OrderLineNotFoundException {
        long o_id = 1L;
        long ol_id = 2L;
        int newQty = 10;

        UpdateOrderLineQtyRequestDto requestDto = new UpdateOrderLineQtyRequestDto(o_id, ol_id, newQty);
        Order existingOrder = Order.builder()
                .id(o_id)
                .listOfOrderLines(List.of(new OrderLine(ol_id, new Product(), 5)))
                .build();
        Mockito.when(repository.findById(any())).thenReturn(Optional.of(existingOrder));

        orderService.updateNumberOfProductsInOrderLine(requestDto);

        verify(repository).save(Order.builder()
                .id(o_id)
                .listOfOrderLines(List.of(new OrderLine(ol_id, new Product(), newQty)))
                .build());
    }

    @Test
    void addOrderLineToOrderCompletesCorrectly() throws ProductNotFoundException, OrderNotFoundException {
        long o_id = 1L;
        long p_id = 2L;
        int qty = 3;
        AddOrderLineToOrderRequestDto requestDto = new AddOrderLineToOrderRequestDto(o_id, p_id, qty);
        Order order = Order.builder().id(o_id).listOfOrderLines(new ArrayList<>()).build();
        Product product = Product.builder().id(p_id).build();
        OrderLine newOrderLine = OrderLine.builder().product(product).quantity(qty).build();
        Order updatedOrder = Order.builder().id(o_id).listOfOrderLines(List.of(newOrderLine)).build();

        Mockito.when(repository.findById(o_id)).thenReturn(Optional.of(order));
        Mockito.when(productService.getProductById(p_id)).thenReturn(product);

        orderService.addOrderLineToOrder(requestDto);

        verify(repository).save(updatedOrder);
     }

}