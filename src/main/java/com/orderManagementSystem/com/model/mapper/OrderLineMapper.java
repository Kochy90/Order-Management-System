package com.orderManagementSystem.com.model.mapper;

import com.orderManagementSystem.com.dto.AddOrderLineToOrderRequestDto;
import com.orderManagementSystem.com.model.OrderLine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderLineMapper {

    OrderLineMapper INSTANCE = Mappers.getMapper(OrderLineMapper.class );

    OrderLine convert(AddOrderLineToOrderRequestDto dto);
}
