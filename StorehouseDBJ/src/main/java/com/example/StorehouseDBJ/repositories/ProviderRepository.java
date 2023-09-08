package com.example.StorehouseDBJ.repositories;

import com.example.StorehouseDBJ.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

    Iterable<Provider> findByTitleContains(String title);
}
