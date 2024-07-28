package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "office_id")
    private Integer officeId;

    @Column(name = "extension")
    private String extension;

    @Column(name = "vacation_hours")
    private Integer vacationHours;

    @Column(name = "reports_to")
    private Integer reportsTo;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @ManyToOne
    @JoinColumn(name = "office_id", insertable = false, updatable = false)
    private Office office;

    @ManyToOne
    @JoinColumn(name = "reports_to", insertable = false, updatable = false)
    private Employee supervisor;
}
