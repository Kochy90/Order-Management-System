package com.orderManagementSystem.com.controller;

import com.orderManagementSystem.com.dto.CreateCustomerRequestDto;
import com.orderManagementSystem.com.model.Customer;
import com.orderManagementSystem.com.model.Order;
import com.orderManagementSystem.com.service.CustomerService;
import com.orderManagementSystem.com.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer-management")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    OrderService orderService;

    @PostMapping("/managed-customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody CreateCustomerRequestDto requestDto) {
        Customer newCustomer = customerService.createCustomer(requestDto);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    // Customer endpoint -> duplicate method, however once security is set up, these methods would be separated by actor roles.
    @GetMapping("/customer/{id}/orders")
    public ResponseEntity<List<Order>> getAllOrdersByCustomerId(@PathVariable Long id) {
        List<Order> orders = orderService.getOrdersByCustomerId(id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


}
