package com.example.order_cart.repository;

import com.example.order_cart.entity.CartEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<CartEntity,String> {
}
