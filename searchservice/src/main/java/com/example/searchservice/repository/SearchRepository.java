package com.example.searchservice.repository;

import com.example.searchservice.entity.Search;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends ElasticsearchRepository<Search,String> {

//    List<Search> findByCategoryAndNameAndAttribute(String category,String name,String attribute);
}
