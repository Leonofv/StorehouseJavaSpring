package com.example.StorehouseDBJ.repositories;

import com.example.StorehouseDBJ.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}