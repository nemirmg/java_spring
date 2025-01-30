package com.example.shop.controllers;


import com.example.shop.model.Product;
import com.example.shop.config.UrlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UrlProperties urlProperties;

    @GetMapping("/")
    public String getProductFromWarehouse(Model model) {
        String warehouseUrl = urlProperties.getUriGetProducts(); // URL модуля warehouse
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                warehouseUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        List<Product> products = response.getBody();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/product/{id}")
    public String getProductDetails(@PathVariable Long id, Model model) {
        String warehouseUrl = urlProperties.getUriGetProduct() + id; // URL модуля warehouse
        ResponseEntity<Product> response = restTemplate.exchange(
                warehouseUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        Product product = response.getBody();
        model.addAttribute("product", product);
        return "product";
    }


    @PostMapping("/buyProduct")
    public ResponseEntity<String> buyProduct(@RequestParam Long productId, @RequestParam int quantity) {
        String warehouseUrl = urlProperties.getReserveProduct(); // URL метода резервации
        MultiValueMap<String, Long> map = new LinkedMultiValueMap<>();
        map.add("productId", productId);
        map.add("quantity", (long) quantity);
        ResponseEntity<String> response = restTemplate.postForEntity(warehouseUrl, map, String.class);
        return response;

    }

}