package com.example.StorehouseDBJ.models;
import com.example.StorehouseDBJ.enums.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Email(message = "The mail field must be in the correct format")
    @NotEmpty(message = "The mail field must not be empty")
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$",
            message = "Invalid number format entered") // Расчитано на российские мобильные и городские с кодом из 3-х цифр!
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Pattern(regexp = "[A-Za-zА-Яа-я]+", message = "The name cannot use numbers or special characters")
    @Size(min = 2, max = 32 , message = "The name cannot have less than 2 or more than 32 characters" )
    @Column(name = "name")
    private String name;
    @Column(name = "active")
    private boolean active;
    @Size(min = 6, max = 100, message = "The password cannot be less than 6 and more than 32 characters")
    @Column(name = "password", length = 100, nullable = false)
    private String password;
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "The password must not contain special characters")
    @Transient
    private String repeatPassword;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "userRole", joinColumns = @JoinColumn(name = "id"))

    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Shop> shops = new ArrayList<>();
    private LocalDateTime dateOfCreated;


    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

    public boolean isAdmin() {
        return roles.contains(Role.ROLE_ADMIN);
    }

    public boolean isUser() {
        return roles.contains(Role.ROLE_USER);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {return email;}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}