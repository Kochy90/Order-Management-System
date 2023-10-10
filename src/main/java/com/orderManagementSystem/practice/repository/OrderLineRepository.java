package com.orderManagementSystem.practice.repository;

import com.orderManagementSystem.practice.model.Order;
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

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE OrderLine ol SET ol.quantity = :qty WHERE ol.id = :id")
    OrderLine updateQuantityOfProducts(@Param("id") Long id, @Param("qty") Integer qty);

    List<OrderLine> getOrderLinesByProduct(Product product);

    // TODO TEST!!!
    @Query("INSERT INTO OrderLine (order, product, quantity) VALUES(:order, :product, :quantity)")
    OrderLine saveOrderLineToExistingOrder(@Param("product") Product product, @Param("quantity") Integer quantity, @Param("order") Order order);

    /**
     * INSERT INTO table_name (column1, column2, column3, ...)
     * VALUES (value1, value2, value3, ...);
     *     Long orderId;
     *     Product product;
     *     Integer quantity;
     */
}
