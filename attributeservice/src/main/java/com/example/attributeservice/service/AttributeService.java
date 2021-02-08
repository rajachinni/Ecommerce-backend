package com.example.attributeservice.service;

import com.example.attributeservice.entity.Attributes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AttributeService {
    Attributes save(Attributes attributes);
    List<Attributes> findAll();
    Attributes findById(String id);
}
