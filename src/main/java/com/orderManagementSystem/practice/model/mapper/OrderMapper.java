package com.orderManagementSystem.practice.model.mapper;

import com.orderManagementSystem.practice.dto.CreateOrderRequestDto;
import com.orderManagementSystem.practice.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class );

    Order convert(CreateOrderRequestDto dto);
}
