package com.orderManagementSystem.practice.model.mapper;

import com.orderManagementSystem.practice.dto.CreateProductRequestDto;
import com.orderManagementSystem.practice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class );

    Product convert(CreateProductRequestDto dto);
}
