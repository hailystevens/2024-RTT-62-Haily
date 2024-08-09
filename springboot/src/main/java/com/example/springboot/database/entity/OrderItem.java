package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "order_items")
// Requirement: Proper primary keys / foreign keys, column names lowercase, pk called id, fk tablename_id
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Requirement: Proper primary keys
    @Column(name = "order_item_id") // The primary key column is named `order_item_id`
    private Long orderItemId;

    @ManyToOne // Requirement: Proper foreign keys
    @JoinColumn(name = "product_id") // The foreign key column is named `product_id`
    private Product product; // This establishes a many-to-one relationship with the `Product` entity

    @ManyToOne // Requirement: Proper foreign keys
    @JoinColumn(name = "order_id") // The foreign key column is named `order_id`
    private Order order; // This establishes a many-to-one relationship with the `Order` entity

    @Column(name = "quantity") // Requirement: Column names lowercase
    private Integer quantity;

    @Column(name = "discount") // Requirement: Column names lowercase
    private double discount;

    @Column(name = "ordered_product_price") // Requirement: Column names lowercase
    private double orderedProductPrice;
}