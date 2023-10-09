package com.orderManagementSystem.practice.repository;

import com.orderManagementSystem.practice.model.OrderLine;
import com.orderManagementSystem.practice.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends CrudRepository<OrderLine, Long> {
    //	- Change quantity of products in an order line

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE OrderLine ol SET ol.quantity = :qty WHERE ol.id = :id")
    OrderLine updateQuantityOfProducts(@Param("id") Long id, @Param("qty") Integer qty);

    List<OrderLine> getOrderLinesByProduct(Product product);
}
