package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class AdditionalElasticsearchMethodsImpl implements AdditionalElasticsearchMethods {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public <T> void saveInIndex(List<T> rows, Function<T, IndexQuery> mapping, String index) {
        List<IndexQuery> queries = rows.stream()
                .map(mapping)
                .collect(Collectors.toList());

        elasticsearchOperations
                .bulkIndex(queries, IndexCoordinates.of(index));

    }
}
