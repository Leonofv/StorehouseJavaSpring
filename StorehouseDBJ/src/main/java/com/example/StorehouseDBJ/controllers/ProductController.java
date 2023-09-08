package com.example.StorehouseDBJ.controllers;

import com.example.StorehouseDBJ.models.Product;
import com.example.StorehouseDBJ.services.ProductService;
import com.example.StorehouseDBJ.services.ShopService;
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
public class ProductController {
    private final ProductService productService;
    private final ShopService shopService;

    @GetMapping("/products")
    public String products(@RequestParam(name = "title", required = false)String title, Principal principal, Model model) {
        model.addAttribute("products", productService.listProducts(title));
        model.addAttribute("user", productService.getUserBuPrincipal(principal));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model, Principal principal) {
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("user", productService.getUserBuPrincipal(principal));
        model.addAttribute("shop", shopService.getShopById(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product, Principal principal) {
        productService.saveProduct(principal, product);
        return "redirect:/products";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    @PostMapping("/product/update/{id}")
    public String updateProduct(@PathVariable Long id, Product product) {
    productService.updateProduct(id, product);
    return "redirect:/products";
    }
}
