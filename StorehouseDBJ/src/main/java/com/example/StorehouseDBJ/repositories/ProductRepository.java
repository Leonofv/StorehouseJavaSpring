package com.example.StorehouseDBJ.repositories;

import com.example.StorehouseDBJ.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Iterable<Product> findByTitleContains(String title);
}
