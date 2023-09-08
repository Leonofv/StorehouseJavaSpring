package com.example.StorehouseDBJ.services;

import com.example.StorehouseDBJ.models.Product;
import com.example.StorehouseDBJ.models.User;
import com.example.StorehouseDBJ.repositories.ProductRepository;
import com.example.StorehouseDBJ.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Iterable<Product> listProducts(String title)  {
        if (title != null)
            try {
                return productRepository.findByTitleContains(title);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        return productRepository.findAll();
    }

    public User getUserBuPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public void saveProduct(Principal principal, Product product) {
        log.info("Saving new {}", product);
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Long id, Product product) {
        productRepository.findById(id);
        log.info("Saving new {}", product);
        productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
