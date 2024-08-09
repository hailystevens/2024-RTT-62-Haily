package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_roles") // Requirement: Proper primary keys / foreign keys, column names lowercase, pk called id, fk tablename_id
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Requirement: Proper primary keys
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id") // Requirement: Foreign key named `tablename_id` (in this case, `user_id`)
    private Integer userId; // This establishes a foreign key relationship with the `User` entity

    @Column(name = "role_name") // Requirement: Column names lowercase
    private String roleName;

    @Column(name = "create_date") // Requirement: Column names lowercase
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
}