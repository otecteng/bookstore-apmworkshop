package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/greeting")
    public ProductDTO greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        ProductDTO dto = new ProductDTO();
        dto.name = "book";
        dto.price = 99.99;
        return dto;
    }
}
