package com.example.StorehouseDBJ.services;

import com.example.StorehouseDBJ.models.Shop;
import com.example.StorehouseDBJ.models.User;
import com.example.StorehouseDBJ.repositories.ShopRepository;
import com.example.StorehouseDBJ.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopService {

    private final ShopRepository shopRepository;
    private final UserRepository userRepository;

    public Iterable<Shop> listShop(String title) {
        if (title != null)
            try {
                return shopRepository.findByTitleContains(title);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        return shopRepository.findAll();
    }

    public void saveShop(Principal principal, Shop shop) {
        shop.setUser(getUserBuPrincipal(principal));
        log.info("Saving new ShopRequest{}: Author email: {}", shop.getTitle(),shop.getUser().getEmail());
        shopRepository.save(shop);
    }

    public User getUserBuPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }

    public void updateShop(Long id, Shop shop) {
        shopRepository.findById(id);
        log.info("Saving new {}", shop);
        shopRepository.save(shop);
    }

    public Shop getShopById(Long id) {
        return shopRepository.findById(id).orElse(null);
    }
}
