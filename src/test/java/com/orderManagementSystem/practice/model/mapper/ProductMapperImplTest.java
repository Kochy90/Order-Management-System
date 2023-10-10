package com.orderManagementSystem.practice.model.mapper;

import com.orderManagementSystem.practice.dto.CreateProductRequestDto;
import com.orderManagementSystem.practice.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class ProductMapperImplTest {

    ProductMapper mapper = new ProductMapperImpl();

    @Test
    public void ShouldMapCreateProductRequestDtoToCustomer() {
        String name = "batmobile";
        String skuCode = "nanananananananabatman";
        Double unitPrice = 1_000_000d;
        //given
        CreateProductRequestDto dto = CreateProductRequestDto.builder()
                .name(name)
                .skuCode(skuCode)
                .unitPrice(unitPrice)
                .build();
        //when
        Product product = mapper.INSTANCE.convert(dto);
        //then
        assertEquals(product.getName(), name);
        assertEquals(product.getSkuCode(), skuCode);
        assertEquals(product.getUnitPrice(), unitPrice);
        assertNull(product.getId());
    }
}
