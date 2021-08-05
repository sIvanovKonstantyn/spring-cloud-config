package com.example.demo.rest;

import com.example.demo.repository.entities.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> findAll() {
        return service.findAll();
    }

    @PostMapping
    public void save(@RequestBody List<Product> products, @RequestParam String index) {

        if (index != null) {
            service.saveInIndex(products, index);
        } else if (products.size() > 1) {
            service.saveAll(products);
        } else {
            service.save(products.stream().findFirst().orElseThrow());
        }
    }
}
