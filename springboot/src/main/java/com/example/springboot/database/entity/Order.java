package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
// Requirement: Proper primary keys / foreign keys, column names lowercase, pk called id, fk tablename_id
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Requirement: Proper primary keys
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Requirement: Proper foreign keys
    @JoinColumn(name = "customer_id", nullable = false) // The foreign key column is named `customer_id`
    private Customer customer; // This establishes a many-to-one relationship with the `Customer` entity

    @Column(name = "order_date") // Requirement: Column names lowercase
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "status") // Requirement: Column names lowercase
    private String status;

    @Column(name = "total_amount") // Requirement: Column names lowercase
    private Double totalAmount;

    @Column(name = "payment_method") // Requirement: Column names lowercase
    private String paymentMethod;

    @Column(name = "shipping_method") // Requirement: Column names lowercase
    private String shippingMethod;

    @Column(name = "tracking_number") // Requirement: Column names lowercase
    private String trackingNumber;

    @Column(name = "special_instructions", columnDefinition = "TEXT") // Requirement: Column names lowercase
    private String specialInstructions;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // Requirement: Use @OneToMany
    private List<OrderDetail> orderDetails; // This establishes a one-to-many relationship with the `OrderDetail` entity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id); // Basic equality check based on `id`
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Generate hash code based on `id`
    }
}