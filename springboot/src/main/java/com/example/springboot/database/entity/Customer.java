package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
// Requirement: Proper primary keys / foreign keys, column names lowercase, pk called id, fk tablename_id
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Requirement: Proper primary keys
    @Column(name = "id")
    private Integer id;

    @Column(name = "name") // Requirement: Column names lowercase
    private String name;

    @Column(name = "email") // Requirement: Column names lowercase
    private String email;

    @Column(name = "phone") // Requirement: Column names lowercase
    private String phone;

    @Column(name = "billing_address") // Requirement: Column names lowercase
    private String billingAddress;

    @Column(name = "shipping_address") // Requirement: Column names lowercase
    private String shippingAddress;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // Requirement: Use @OneToMany
    private List<Order> orders; // This establishes a one-to-many relationship with the `Order` entity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) && name.equals(customer.name); // Basic equality check based on `id` and `name`
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name); // Generate hash code based on `id` and `name`
    }
}
