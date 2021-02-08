package com.example.order_cart.repository;

import com.example.order_cart.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity,String> {
}
