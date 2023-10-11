package com.orderManagementSystem.com.model.mapper;

import com.orderManagementSystem.com.dto.CreateOrderRequestDto;
import com.orderManagementSystem.com.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class );

    Order convert(CreateOrderRequestDto dto);
}
