package com.example.StorehouseDBJ.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Table (name = "product")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @NotEmpty(message = "Can not be empty")
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private String price;
    @Column(name = "quantity")
    private String quantity;
    @NotEmpty(message = "Can not be empty")
    @Pattern(regexp = "(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)+",
            message = "Incorrect date format")
    @Column(name = "dateOfDelivery")
    private String DateOfDelivery;
    @Column(name = "description")
    private String description;
    @NotEmpty(message = "Can not be empty")
    @Column(name = "manufacturer")
    private String manufacturer;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
}