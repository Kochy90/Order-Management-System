package com.orderManagementSystem.practice.service;

import com.orderManagementSystem.practice.dto.AddOrderLineToOrderDto;
import com.orderManagementSystem.practice.dto.UpdateOrderLineQtyRequestDto;
import com.orderManagementSystem.practice.model.OrderLine;
import com.orderManagementSystem.practice.model.Product;

import java.util.List;

public interface OrderLineService {

    OrderLine changeQuantityOfProducts(UpdateOrderLineQtyRequestDto dto);
//    OrderLine addOrderLineToOrder(AddOrderLineToOrderDto dto);

}
