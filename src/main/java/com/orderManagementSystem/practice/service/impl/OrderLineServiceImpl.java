package com.orderManagementSystem.practice.service.impl;

import com.orderManagementSystem.practice.model.Product;
import com.orderManagementSystem.practice.repository.OrderLineRepository;
import com.orderManagementSystem.practice.dto.UpdateOrderLineQtyRequestDto;
import com.orderManagementSystem.practice.model.OrderLine;
import com.orderManagementSystem.practice.service.OrderLineService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    OrderLineRepository repository;

    public OrderLine changeQuantityOfProducts(UpdateOrderLineQtyRequestDto dto) {
        if (repository.findById(dto.getId()).isPresent()) {
            return null;
        }
        return repository.updateQuantityOfProducts(dto.getId(), dto.getQuantity());
    }

    public List<OrderLine> getOrderLinesByProduct(Product product) {
        return null;
    }
}
