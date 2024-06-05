package org.example.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "extension")
    private String extension;
    @Column(name = "reports_to")
    private Integer reportsTo;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "office_id")
    private Integer officeId;
    @Column(name = "profile_image_url")
    private String profileImageUrl;
    @Column(name = "vacation_hours")
    private Integer vacationHours;
}