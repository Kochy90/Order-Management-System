package com.orderManagementSystem.com.service;

import com.orderManagementSystem.com.dto.AddOrderLineToOrderRequestDto;
import com.orderManagementSystem.com.dto.CreateOrderRequestDto;
import com.orderManagementSystem.com.dto.UpdateOrderLineQtyRequestDto;
import com.orderManagementSystem.com.exception.OrderLineNotFoundException;
import com.orderManagementSystem.com.exception.OrderNotFoundException;
import com.orderManagementSystem.com.exception.ProductNotFoundException;
import com.orderManagementSystem.com.model.Order;

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
