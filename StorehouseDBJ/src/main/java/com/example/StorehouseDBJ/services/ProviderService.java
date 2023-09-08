package com.example.StorehouseDBJ.services;

import com.example.StorehouseDBJ.models.Provider;
import com.example.StorehouseDBJ.models.User;
import com.example.StorehouseDBJ.repositories.ProviderRepository;
import com.example.StorehouseDBJ.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProviderService {

    private final ProviderRepository providerRepository;
    private final UserRepository userRepository;

    public Iterable<Provider> listProvider(String title) {
        if (title != null)
            try {
                return providerRepository.findByTitleContains(title);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        return providerRepository.findAll();
    }

    public User getUserBuPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public void saveProvider(Provider provider) {
        log.info("Saving new {}", provider);
        providerRepository.save(provider);
    }

    public void deleteProvider(Long id) {
        providerRepository.deleteById(id);
    }

    public void updateProvider(Long id, Provider provider) {
        providerRepository.findById(id);
        log.info("Saving new {}", provider);
        providerRepository.save(provider);
    }

    public Provider getProviderById(Long id) {
        return providerRepository.findById(id).orElse(null);
    }

}

