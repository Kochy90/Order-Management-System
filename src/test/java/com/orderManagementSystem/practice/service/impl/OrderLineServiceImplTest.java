package com.orderManagementSystem.practice.service.impl;

import com.orderManagementSystem.practice.dto.UpdateOrderLineQtyRequestDto;
import com.orderManagementSystem.practice.model.OrderLine;
import com.orderManagementSystem.practice.model.Product;
import com.orderManagementSystem.practice.repository.OrderLineRepository;
import com.orderManagementSystem.practice.service.OrderLineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OrderLineServiceImplTest {

    OrderLineService orderLineService;

    @Mock
    OrderLineRepository repository;

    @BeforeEach
    void setUp() {
        orderLineService = new OrderLineServiceImpl(repository);
    }

//    @Test
//    void changeQuantityOfProductsCallsCorrectRepositoryMethod() {
//        Long id = 2L;
//        Product product = new Product();
//        //given
//        UpdateOrderLineQtyRequestDto dto = new UpdateOrderLineQtyRequestDto(id,10 );
//        Mockito.when(repository.findById(dto.getId())).thenReturn(Optional.of(new OrderLine(id,new Product(), 5)));
//        //when
//        orderLineService.changeQuantityOfProducts(dto);
//        //then
//        verify(repository).updateQuantityOfProducts(dto.getId(), dto.getQuantity());
//    }

    @Test
    void changeQuantityOfProductsDoesNotCallMethodWhenOrderLineNotFound() {
        //given
        UpdateOrderLineQtyRequestDto dto = new UpdateOrderLineQtyRequestDto(4L,10 );
        Mockito.when(repository.findById(dto.getId())).thenReturn(Optional.empty());
        //when
        orderLineService.changeQuantityOfProducts(dto);
        //then
        verify(repository, never()).updateQuantityOfProducts(dto.getId(), dto.getQuantity());
    }

}