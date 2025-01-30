package com.example.warehouse.controllers;

import com.example.warehouse.model.Product;
import com.example.warehouse.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    private ProductService productService;


    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }


    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getProducts(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }


    @PostMapping("/reserveProduct")
    @Transactional
    public ResponseEntity<String> reserveProduct(@RequestParam Long productId, @RequestParam int quantity) {
        productService.reserveProduct(productId, quantity);
        return ResponseEntity.ok("Product reserved successfully");
    }

}