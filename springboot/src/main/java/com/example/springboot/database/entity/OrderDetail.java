package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Setter
@Getter
@Entity
@ToString(exclude = {"order", "product"}) // Exclude fields that might cause recursion
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderdetails")
// Requirement: Proper primary keys / foreign keys, column names lowercase, pk called id, fk tablename_id
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Requirement: Proper primary keys
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Requirement: Proper foreign keys
    @JoinColumn(name = "order_id", nullable = false) // The foreign key column is named `order_id`
    private Order order; // This establishes a many-to-one relationship with the `Order` entity

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Requirement: Proper foreign keys
    @JoinColumn(name = "product_id", nullable = false) // The foreign key column is named `product_id`
    private Product product; // This establishes a many-to-one relationship with the `Product` entity

    @Column(name = "quantity_ordered") // Requirement: Column names lowercase
    private Integer quantityOrdered;

    @Column(name = "price_each", columnDefinition = "DECIMAL(10,2)") // Requirement: Column names lowercase
    private Double priceEach;

    @Column(name = "order_line_number") // Requirement: Column names lowercase
    private Short orderLineNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return id.equals(that.id); // Basic equality check based on `id`
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Generate hash code based on `id`
    }
}
