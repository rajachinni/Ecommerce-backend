package com.example.searchservice.service.impl;

import com.example.searchservice.entity.Search;
import com.example.searchservice.repository.SearchRepository;
import com.example.searchservice.service.SearchService;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    SearchRepository searchRepository;

    @Override
    public Search save(Search search){
        return searchRepository.save(search);
    }
    @Override
    public List<Search> findByCategoryAndNameAndAttribute(String attribute) {
        Query query = new NativeSearchQueryBuilder()
                .withQuery(multiMatchQuery(attribute)
                .field("productName").field("attribute").field("category").type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
                .build();
        return searchRepository.search(query).getContent();
    }
    @Override
    public void deleteAll(){
        searchRepository.deleteAll();
    }
}