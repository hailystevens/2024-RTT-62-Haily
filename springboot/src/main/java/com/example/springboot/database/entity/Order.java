package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ToString.Exclude
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private int customerId;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "required_date")
    private LocalDateTime requiredDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comments", columnDefinition = "Text")
    private String comment;
}
