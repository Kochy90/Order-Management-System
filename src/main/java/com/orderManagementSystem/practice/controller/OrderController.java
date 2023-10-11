package com.orderManagementSystem.practice.controller;

import com.orderManagementSystem.practice.dto.AddOrderLineToOrderRequestDto;
import com.orderManagementSystem.practice.dto.CreateOrderRequestDto;
import com.orderManagementSystem.practice.dto.UpdateOrderLineQtyRequestDto;
import com.orderManagementSystem.practice.exception.OrderLineNotFoundException;
import com.orderManagementSystem.practice.exception.OrderNotFoundException;
import com.orderManagementSystem.practice.exception.ProductNotFoundException;
import com.orderManagementSystem.practice.model.Order;
import com.orderManagementSystem.practice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



//    @GetMapping("/managed-orders/orders/search")
//    public ResponseEntity<List<Order>> getAllOrdersByDate(@PathVariable Long id) {
//        List<Order> orders = orderService.getOrdersByDate(Date date);
//        return new ResponseEntity<>(orders, HttpStatus.OK);
//    }



}
