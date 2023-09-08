package com.example.StorehouseDBJ.repositories;

import com.example.StorehouseDBJ.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    Iterable<Shop> findByTitleContains(String title);
}
