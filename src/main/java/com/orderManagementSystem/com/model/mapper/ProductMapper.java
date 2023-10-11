package com.orderManagementSystem.com.model.mapper;

import com.orderManagementSystem.com.dto.CreateProductRequestDto;
import com.orderManagementSystem.com.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class );

    Product convert(CreateProductRequestDto dto);
}
