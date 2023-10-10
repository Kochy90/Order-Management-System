package com.orderManagementSystem.practice.service.impl;

import com.orderManagementSystem.practice.repository.OrderRepository;
import com.orderManagementSystem.practice.dto.CreateOrderRequestDto;
import com.orderManagementSystem.practice.model.Customer;
import com.orderManagementSystem.practice.model.Order;
import com.orderManagementSystem.practice.model.Product;
import com.orderManagementSystem.practice.model.mapper.OrderMapper;
import com.orderManagementSystem.practice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private final OrderRepository repository;

    @Override
    public Order createOrder(CreateOrderRequestDto dto) {
        Order newOrder = OrderMapper.INSTANCE.convert(dto);
        return repository.save(newOrder);
    }

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
        return repository.findOrdersByProductId(product.getId());
    }

    @Override
    public List<Order> getOrdersByCustomer(Customer customer) {
        return repository.findOrdersByCustomer(customer);
    }


    /**
     * 	- Search Orders by product	(using both JPQL and Criteria/Specification queries)
     * 	- Search Orders by customer (using both JPQL and Criteria/Specification queries)
     */
}
