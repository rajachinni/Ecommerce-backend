package com.example.searchservice.controller;

import com.example.searchservice.entity.Search;
import com.example.searchservice.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/search")
public class SearchController {
    @Autowired
    SearchService searchService;


    @PostMapping(value = "/add")
    public Search save(@RequestBody Search search) {
        return searchService.save(search);
    }

    @GetMapping(value = "/searching/{attribute}")
    public List<Search> findByCategoryAndNameAndAttribute(@PathVariable("attribute") String attribute){
        return searchService.findByCategoryAndNameAndAttribute(attribute);
    }
    @DeleteMapping(value="/delete")
    public void deleteAll(){
        searchService.deleteAll();
    }
}

