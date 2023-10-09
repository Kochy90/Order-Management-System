package com.orderManagementSystem.practice.repository;

import com.orderManagementSystem.practice.model.Customer;
import com.orderManagementSystem.practice.model.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

//    @Modifying(clearAutomatically = true, flushAutomatically = true)
//    @Query("SELECT o FROM Order o WHERE o.submission_date = :date")
//    List<Order> findOrderBySubmissionDate1(@Param("date") Date date);
    //    @Query("select a from Article a where a.creationDateTime <= :creationDateTime")
//    Order findOrderBySubmissionDate(Date date);


//    Order findOrderByProduct(Product product);
    Order findOrderByCustomer(Customer customer);
    List<Order> findOrdersBySubmissionDate(Date date);

//    @Modifying(clearAutomatically = true, flushAutomatically = true)
//    @Query("SELECT o FROM Order o JOIN order_line ol ON o.id = ol.order_id WHERE ol.product_id = productId")
//    List<Order> findOrdersByProductId(@Param("productId") Long productId);

    List<Order> findOrdersByCustomer(Customer customer);
}
