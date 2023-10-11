package com.orderManagementSystem.practice.service;

import com.orderManagementSystem.practice.dto.AddOrderLineToOrderRequestDto;
import com.orderManagementSystem.practice.dto.CreateOrderRequestDto;
import com.orderManagementSystem.practice.dto.UpdateOrderLineQtyRequestDto;
import com.orderManagementSystem.practice.exception.OrderLineNotFoundException;
import com.orderManagementSystem.practice.exception.OrderNotFoundException;
import com.orderManagementSystem.practice.exception.ProductNotFoundException;
import com.orderManagementSystem.practice.model.Customer;
import com.orderManagementSystem.practice.model.Order;
import com.orderManagementSystem.practice.model.Product;

import java.util.Date;
import java.util.List;

public interface OrderService {
    // TODO check correct Date type is used
    Order createOrder(CreateOrderRequestDto dto);

    List<Order> getOrdersByDate(Date date);
    List<Order> getOrdersByCustomerId(Long customerId);
    List<Order> getOrdersByProductId(Long productName);
    Boolean isOrderExists(Long orderId);
    Order addOrderLineToOrder(AddOrderLineToOrderRequestDto requestDto) throws ProductNotFoundException, OrderNotFoundException;
    Order updateNumberOfProductsInOrderLine(UpdateOrderLineQtyRequestDto requestDto) throws OrderLineNotFoundException, OrderNotFoundException;


}
