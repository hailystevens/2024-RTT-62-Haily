package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users") // Requirement: Proper primary keys / foreign keys, column names lowercase, pk called id, fk tablename_id
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Requirement: Proper primary keys
    @Column(name = "id")
    private Integer id;

    @Column(name = "email") // Requirement: Column names lowercase
    private String email;

    @Column(name = "password") // Requirement: Column names lowercase
    private String password;

    @Column(name = "create_date") // Requirement: Column names lowercase
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
}