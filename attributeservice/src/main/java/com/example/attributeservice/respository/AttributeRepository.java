package com.example.attributeservice.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.attributeservice.entity.Attributes;

@Repository
public interface AttributeRepository extends MongoRepository<Attributes, String> {
}
