package com.example.StorehouseDBJ.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Table(name = "shop")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @NotEmpty(message = "Can not be empty")
    @Column(name = "title")
    private String title;
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}")
    @NotEmpty(message = "Can not be empty")
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @NotEmpty(message = "Can not be empty")
    @Column(name = "mail")
    private String mail;
    @Column(name = "address")
    private String address;
    @Column(name = "productTitle")
    private String productTitle;
    @Column(name = "productQuantity")
    private String productQuantity;
    @Column(name = "productPrice")
    private String productPrice;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
}
