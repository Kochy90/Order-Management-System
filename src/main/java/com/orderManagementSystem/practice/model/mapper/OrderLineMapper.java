package com.orderManagementSystem.practice.model.mapper;

import com.orderManagementSystem.practice.dto.AddOrderLineToOrderRequestDto;
import com.orderManagementSystem.practice.model.OrderLine;
import com.orderManagementSystem.practice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderLineMapper {

    OrderLineMapper INSTANCE = Mappers.getMapper(OrderLineMapper.class );

    OrderLine convert(AddOrderLineToOrderRequestDto dto);
}
