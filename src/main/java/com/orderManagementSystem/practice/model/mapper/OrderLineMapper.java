package com.orderManagementSystem.practice.model.mapper;

import com.orderManagementSystem.practice.dto.AddOrderLineToOrderDto;
import com.orderManagementSystem.practice.model.OrderLine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderLineMapper {

    OrderLineMapper INSTANCE = Mappers.getMapper(OrderLineMapper.class );

    OrderLine convert(AddOrderLineToOrderDto dto);
}
