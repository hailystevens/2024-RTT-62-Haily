package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderdetails")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @Column(name = "order_id", insertable = false, updatable = false)
    private int orderId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_id", insertable = false, updatable = false)
    private Integer productId;

    @Column(name = "quantity_ordered")
    private Integer quantityOrdered = 0;

    @Column(name = "price_each", columnDefinition = "DECIMAL(10,2)")
    private Double priceEach;

    @Column(name = "order_line_number")
    private Short orderLineNumber;

    @Transient
    private String productName;

    public String getProductName() {
        return productName;
    }
}
