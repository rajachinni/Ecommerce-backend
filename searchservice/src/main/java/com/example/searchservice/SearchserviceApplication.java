package com.example.searchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class SearchserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchserviceApplication.class, args);
	}
}
