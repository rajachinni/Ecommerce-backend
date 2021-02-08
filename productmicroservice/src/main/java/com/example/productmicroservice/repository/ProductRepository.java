package com.example.productmicroservice.repository;

import com.example.productmicroservice.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProductRepository extends MongoRepository<Product, String> {

}
