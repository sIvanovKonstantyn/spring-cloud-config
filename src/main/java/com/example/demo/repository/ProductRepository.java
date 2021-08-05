package com.example.demo.repository;

import com.example.demo.repository.entities.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String>, AdditionalElasticsearchMethods {
}
