package com.orderManagementSystem.practice.service.impl;

import com.orderManagementSystem.practice.repository.OrderRepository;
import com.orderManagementSystem.practice.dto.CreateOrderRequestDto;
import com.orderManagementSystem.practice.model.Customer;
import com.orderManagementSystem.practice.model.Order;
import com.orderManagementSystem.practice.model.Product;
import com.orderManagementSystem.practice.model.mapper.OrderMapper;
import com.orderManagementSystem.practice.service.OrderLineService;
import com.orderManagementSystem.practice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderLineService orderLineService;

    @Override
    public Order createOrder(CreateOrderRequestDto dto) {
        Order newOrder = OrderMapper.INSTANCE.convert(dto);
        return repository.save(newOrder);
    }

//    @Override
//    public Order getOrderByDate(Date date) {
//        return repository.findOrderBySubmissionDate(date);
//        return repository.findOrderBySubmissionDate1(date);
//    }

//    @Override
//    public Order getOrderByProduct(Product product) {
//        return repository.findOrderByProduct(product);
//    }

    @Override
    public Order getOrderByCustomer(Customer customer) {
        return repository.findOrderByCustomer(customer);
    }

    @Override
    public List<Order> getOrdersByDate(Date date) {
        return repository.findOrdersBySubmissionDate(date);
    }

    @Override
    public List<Order> getOrdersByProduct(Product product) {
//        return repository.findOrdersByProductId(product.getId());
        return null;
    }

    @Override
    public List<Order> getOrdersByCustomer(Customer customer) {
        return repository.findOrdersByCustomer(customer);
    }
}
