package com.orderManagementSystem.com.service.impl;

import com.orderManagementSystem.com.dto.AddOrderLineToOrderRequestDto;
import com.orderManagementSystem.com.dto.UpdateOrderLineQtyRequestDto;
import com.orderManagementSystem.com.exception.OrderLineNotFoundException;
import com.orderManagementSystem.com.exception.OrderNotFoundException;
import com.orderManagementSystem.com.exception.ProductNotFoundException;
import com.orderManagementSystem.com.model.OrderLine;
import com.orderManagementSystem.com.repository.OrderRepository;
import com.orderManagementSystem.com.dto.CreateOrderRequestDto;
import com.orderManagementSystem.com.model.Order;
import com.orderManagementSystem.com.model.Product;
import com.orderManagementSystem.com.model.mapper.OrderMapper;
import com.orderManagementSystem.com.service.OrderService;
import com.orderManagementSystem.com.service.ProductService;
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

    //Todo: add validation logic, make sure date type is correct
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

}
