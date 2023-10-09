package com.orderManagementSystem.practice.service;

import com.orderManagementSystem.practice.dto.CreateOrderRequestDto;
import com.orderManagementSystem.practice.model.Customer;
import com.orderManagementSystem.practice.model.Order;
import com.orderManagementSystem.practice.model.Product;

import java.util.Date;
import java.util.List;

public interface OrderService {
    // TODO check correct Date class is used
    Order createOrder(CreateOrderRequestDto dto);
//    Order getOrderByDate(Date date);
//    Order getOrderByProduct(Product product);
    Order getOrderByCustomer(Customer customer);

    List<Order> getOrdersByDate(Date date);
    List<Order> getOrdersByProduct(Product product);
    List<Order> getOrdersByCustomer(Customer customer);

}
