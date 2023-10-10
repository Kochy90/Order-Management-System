package com.orderManagementSystem.practice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany()
    @JoinColumn(name = "fk_order_line_id")
    private List<OrderLine> listOfOrderLines;

    @Temporal(TemporalType.DATE)
    @Column(name = "submission_date", nullable = false, updatable = false)
    @CreatedDate
    private Date submissionDate;

}
