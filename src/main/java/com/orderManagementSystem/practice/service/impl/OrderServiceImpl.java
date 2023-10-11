package com.orderManagementSystem.practice.service.impl;

import com.orderManagementSystem.practice.dto.AddOrderLineToOrderRequestDto;
import com.orderManagementSystem.practice.dto.UpdateOrderLineQtyRequestDto;
import com.orderManagementSystem.practice.exception.OrderLineNotFoundException;
import com.orderManagementSystem.practice.exception.OrderNotFoundException;
import com.orderManagementSystem.practice.exception.ProductNotFoundException;
import com.orderManagementSystem.practice.model.OrderLine;
import com.orderManagementSystem.practice.repository.OrderRepository;
import com.orderManagementSystem.practice.dto.CreateOrderRequestDto;
import com.orderManagementSystem.practice.model.Order;
import com.orderManagementSystem.practice.model.Product;
import com.orderManagementSystem.practice.model.mapper.OrderMapper;
import com.orderManagementSystem.practice.service.OrderService;
import com.orderManagementSystem.practice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private final OrderRepository repository;

    @Autowired
    private final ProductService productService;

    @Override
    public Order createOrder(CreateOrderRequestDto dto) {
        Order newOrder = OrderMapper.INSTANCE.convert(dto);
        return repository.save(newOrder);
    }

    @Override
    public List<Order> getOrdersByDate(Date date) {
        return repository.findOrdersBySubmissionDate(date);
    }

    @Override
    public List<Order> getOrdersByProductId(Long productId) {
        return repository.findOrdersByProductId(productId);
    }

    @Override
    public Boolean isOrderExists(Long orderId) {
        return repository.existsById(orderId);
    }

    @Override
    public Order addOrderLineToOrder(AddOrderLineToOrderRequestDto requestDto)
            throws ProductNotFoundException, OrderNotFoundException {
        Optional<Order> optionalOrder = repository.findById(requestDto.getOrderId());
        Product product = productService.getProductById(requestDto.getProductId());

        if (optionalOrder.isPresent()) {
            optionalOrder.get().addToListOfOrderLines(new OrderLine(product, requestDto.getQuantity()));
            return repository.save(optionalOrder.get());
        } else {
            throw new OrderNotFoundException();
        }
    }

    @Override
    public Order updateNumberOfProductsInOrderLine(UpdateOrderLineQtyRequestDto requestDto)
            throws OrderLineNotFoundException, OrderNotFoundException {
        Optional<Order> optionalOrder = repository.findById(requestDto.getOrderId());

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            List<OrderLine> orderLines = order.getListOfOrderLines();

            int index = orderLines.indexOf(orderLines.stream()
                    .filter(ol -> ol.getId().equals(requestDto.getOrderLineId()))
                    .findFirst()
                    .orElseThrow(OrderLineNotFoundException::new));

            order.updateQuantityOfProductsByOrderLineIndex(index, requestDto.getQuantity());
            return repository.save(order);
        } else {
            throw new OrderNotFoundException();
        }
    }

    @Override
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return repository.findOrdersByCustomerId(customerId);
    }


    /**
     * 	- Search Orders by product	(using both JPQL and Criteria/Specification queries)
     * 	- Search Orders by customer (using both JPQL and Criteria/Specification queries)
     */
}
