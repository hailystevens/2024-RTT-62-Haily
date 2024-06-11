package org.example.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "productlines")
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_line")
    private String productLine;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "productlineId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;
}

