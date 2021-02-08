package com.example.productmicroservice.services.impl;

import com.example.productmicroservice.entity.Product;
import com.example.productmicroservice.repository.ProductRepository;
import com.example.productmicroservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product findById(String id){
        return productRepository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public int getStock(String id) {
        return productRepository.findById(id).get().getStock();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
