package com.example.productmicroservice.services;

import com.example.productmicroservice.entity.Product;

import java.util.List;

public interface ProductService {
    Product findById(String id);
    List<Product> findAll();
    Product save(Product product);
    int getStock(String id);
}
