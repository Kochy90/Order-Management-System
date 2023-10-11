package com.orderManagementSystem.com.repository;

import com.orderManagementSystem.com.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findOrdersBySubmissionDate(Date date);

    @Query("SELECT o FROM Order o, OrderLine l WHERE l.product.id = :prodId")
    List<Order> findOrdersByProductId(@Param("prodId") Long productId);

    @Query("SELECT o FROM Order o, OrderLine l WHERE l.customer.id = :customerId")
    List<Order> findOrdersByCustomerId(Long customerId);

    /**
     * 	- Search Orders by product	(using both JPQL and Criteria/Specification queries)
     * 	- Search Orders by customer (using both JPQL and Criteria/Specification queries)
     */

}
