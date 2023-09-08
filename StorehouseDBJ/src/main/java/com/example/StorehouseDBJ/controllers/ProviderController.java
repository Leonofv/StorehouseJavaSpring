package com.example.StorehouseDBJ.controllers;

import com.example.StorehouseDBJ.models.Provider;
import com.example.StorehouseDBJ.services.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ProviderController {
    private final ProviderService providerService;

    @GetMapping("/providers")
    public String provider(@RequestParam(name = "title", required = false)String title, Principal principal, Model model) {
        model.addAttribute("providers", providerService.listProvider(title));
        model.addAttribute("user", providerService.getUserBuPrincipal(principal));
        return "providers";
    }
    @GetMapping("/provider/{id}")
    public String providerInfo(@PathVariable Long id, Model model, Principal principal) {
        model.addAttribute("provider", providerService.getProviderById(id));
        model.addAttribute("user", providerService.getUserBuPrincipal(principal));
        return "provider-info";
    }

    @PostMapping("/provider/create")
    public String createProvider(Provider provider) {
        providerService.saveProvider(provider);
        return "redirect:/providers";
    }

    @PostMapping("/provider/delete/{id}")
    public String deleteProvider(@PathVariable Long id) {
        providerService.deleteProvider(id);
        return "redirect:/providers";
    }

    @PostMapping("/provider/update/{id}")
    public String updateProvider(@PathVariable Long id, Provider provider) {
        providerService.updateProvider(id, provider);
        return "redirect:/providers";
    }

}

