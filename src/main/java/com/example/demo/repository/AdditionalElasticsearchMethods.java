package com.example.demo.repository;

import org.springframework.data.elasticsearch.core.query.IndexQuery;

import java.util.List;
import java.util.function.Function;

public interface AdditionalElasticsearchMethods {
    <T> void saveInIndex(final List<T> rows, Function<T, IndexQuery> mapping, String index);
}
