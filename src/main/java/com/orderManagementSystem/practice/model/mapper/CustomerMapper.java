package com.orderManagementSystem.practice.model.mapper;

import com.orderManagementSystem.practice.dto.CreateCustomerRequestDto;
import com.orderManagementSystem.practice.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class );

    Customer convert(CreateCustomerRequestDto dto);
}
