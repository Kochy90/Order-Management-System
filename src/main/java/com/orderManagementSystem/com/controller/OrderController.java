package com.orderManagementSystem.com.controller;

import com.orderManagementSystem.com.dto.AddOrderLineToOrderRequestDto;
import com.orderManagementSystem.com.dto.CreateOrderRequestDto;
import com.orderManagementSystem.com.dto.UpdateOrderLineQtyRequestDto;
import com.orderManagementSystem.com.exception.OrderLineNotFoundException;
import com.orderManagementSystem.com.exception.OrderNotFoundException;
import com.orderManagementSystem.com.exception.ProductNotFoundException;
import com.orderManagementSystem.com.model.Order;
import com.orderManagementSystem.com.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-management")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/managed-orders")
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequestDto requestDto) {
        Order newOrder = orderService.createOrder(requestDto);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    //Admin endpoint, potential data collection usage, duplicated with customer controller due to different role access
    @GetMapping("/managed-orders/customers/{id}")
    public ResponseEntity<List<Order>> getAllOrdersByCustomerId(@PathVariable Long id) {
        List<Order> orders = orderService.getOrdersByCustomerId(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/managed-orders/products")
    public ResponseEntity<List<Order>> getAllOrdersByProductId(@RequestBody Long productId) {
        List<Order> orders = orderService.getOrdersByProductId(productId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping("/managed-orders/orders")
    public ResponseEntity<Order> addOrderLineToOrder(@RequestBody AddOrderLineToOrderRequestDto requestDto)
            throws OrderNotFoundException, ProductNotFoundException {
        Order order = orderService.addOrderLineToOrder(requestDto);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PatchMapping("/managed-orders/order-lines")
    public ResponseEntity<Order> updateQtyOfProductsInOrderLine(@RequestBody UpdateOrderLineQtyRequestDto requestDto)
            throws OrderNotFoundException, OrderLineNotFoundException {
        Order order = orderService.updateNumberOfProductsInOrderLine(requestDto);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/managed-orders/orders/date")
    public ResponseEntity<List<Order>> getAllOrdersByDate(@RequestBody Date date) {
        List<Order> orders = orderService.getOrdersByDate(date);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
