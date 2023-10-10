package com.orderManagementSystem.practice.repository;

import com.orderManagementSystem.practice.model.Customer;
import com.orderManagementSystem.practice.model.Order;
import com.orderManagementSystem.practice.model.OrderLine;
import com.orderManagementSystem.practice.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    Order findOrderByCustomer(Customer customer);
    List<Order> findOrdersBySubmissionDate(Date date);

    @Query("SELECT o FROM Order o, OrderLine l WHERE l.product.id = :pId")
    List<Order> findOrdersByProductId(@Param("pId") Long productId);

    @Query("SELECT o FROM Order o, OrderLine l WHERE l.product = :prod")
    List<Order> findOrdersByProduct(@Param("prod") Product product);

    List<Order> findOrdersByCustomer(Customer customer);

}
