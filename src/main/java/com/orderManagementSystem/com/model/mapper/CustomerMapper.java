package com.orderManagementSystem.com.model.mapper;

import com.orderManagementSystem.com.dto.CreateCustomerRequestDto;
import com.orderManagementSystem.com.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class );

    Customer convert(CreateCustomerRequestDto dto);
}
