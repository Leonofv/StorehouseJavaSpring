
package com.example.StorehouseDBJ.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Table (name = "provider")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Provider {
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
    @Email(message = "must be a valid")
    @NotEmpty(message = "Can not be empty")
    @Column(name = "mail")
    private String mail;
    @NotEmpty(message = "Can not be empty")
    @Column(name = "address")
    private String address;
    @Column(name = "website")
    private String website;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
}

