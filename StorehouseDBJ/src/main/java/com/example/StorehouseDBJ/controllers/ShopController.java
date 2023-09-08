package com.example.StorehouseDBJ.controllers;

import com.example.StorehouseDBJ.models.Shop;
import com.example.StorehouseDBJ.services.ProductService;
import com.example.StorehouseDBJ.services.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;
    private final ProductService productService;

    @GetMapping("/shops")
    public String shop(@RequestParam(name = "title", required = false) String title, Principal principal, Model model) {
        model.addAttribute("shops", shopService.listShop(title));
        model.addAttribute("user", shopService.getUserBuPrincipal(principal));
        return "shops";
    }

    @GetMapping("/shop/{id}")
    public String shopInfo(@PathVariable Long id, Model model, Principal principal) {
        model.addAttribute("products", productService.getProductById(id));
        model.addAttribute("shop", shopService.getShopById(id));
        model.addAttribute("user", shopService.getUserBuPrincipal(principal));
        return "shop-info";
    }

    @PostMapping("/shop/create")
    public String createShop(Shop shop, Principal principal) {
        shopService.saveShop(principal, shop);
        return "redirect:/shops";
    }

    @PostMapping("/shop/delete/{id}")
    public String deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return "redirect:/shops";
    }

    @PostMapping("/shop/update/{id}")
    public String updateShop(@PathVariable Long id, Shop shop) {
        shopService.updateShop(id, shop);
        return "redirect:/shops";
    }
}