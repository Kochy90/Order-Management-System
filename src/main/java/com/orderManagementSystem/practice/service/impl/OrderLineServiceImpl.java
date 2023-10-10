package com.orderManagementSystem.practice.service.impl;

import com.orderManagementSystem.practice.dto.AddOrderLineToOrderDto;
import com.orderManagementSystem.practice.model.mapper.OrderLineMapper;
import com.orderManagementSystem.practice.repository.OrderLineRepository;
import com.orderManagementSystem.practice.dto.UpdateOrderLineQtyRequestDto;
import com.orderManagementSystem.practice.model.OrderLine;
import com.orderManagementSystem.practice.service.OrderLineService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    OrderLineRepository repository;

    public OrderLine changeQuantityOfProducts(UpdateOrderLineQtyRequestDto dto) {
        if (repository.findById(dto.getId()).isEmpty()) {
            return null;
        }
        return repository.updateQuantityOfProducts(dto.getId(), dto.getQuantity());
    }

//    @Override
//    public OrderLine addOrderLineToOrder(AddOrderLineToOrderDto dto) {
//        OrderLine newOrderLine = OrderLineMapper.INSTANCE.convert(dto);
//        return repository.saveOrderLineToExistingOrder(newOrderLine, dto.getOrderId());
//    }

}
