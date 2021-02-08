package com.example.searchservice.service;

import com.example.searchservice.entity.Search;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface SearchService {

    Search save(Search search);
//    List<Search> findByCustomQuery(String attribute);
//    List<Search> findByCategory(String category);
    List<Search> findByCategoryAndNameAndAttribute(String attribute);
    void deleteAll();
}