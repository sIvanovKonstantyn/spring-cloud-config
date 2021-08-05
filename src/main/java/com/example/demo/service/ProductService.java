package com.example.demo.service;

import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void saveAll(final List<Product> products) {
        productRepository.saveAll(products);
    }

    public void save(final Product product) {
        productRepository.save(product);
    }

    public void saveInIndex(final List<Product> products, String index) {

        productRepository.saveInIndex(
                products,
                product -> new IndexQueryBuilder().withId(product.getId()).withObject(product).build(),
                index
        );
    }

    public List<Product> findAll() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
