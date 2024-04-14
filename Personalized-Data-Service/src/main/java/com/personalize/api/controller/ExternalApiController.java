package com.personalize.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalize.api.entity.Product;
import com.personalize.api.exceptions.ResourceNotFoundException;
import com.personalize.api.service.ProductService;

@RestController
@RequestMapping("/external")
public class ExternalApiController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductsByShopperId(
            @RequestParam String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(defaultValue = "10") Integer limit) {
        List<Product> products = productService.getProductsByShopperId(shopperId, category, brand, limit);
        if (products == null ) {
            throw new ResourceNotFoundException("Products not found");
        }
        return ResponseEntity.ok(products);
    }
}
