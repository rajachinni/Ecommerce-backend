package com.example.attributeservice.service.impl;

import com.example.attributeservice.entity.Attributes;
import com.example.attributeservice.respository.AttributeRepository;
import com.example.attributeservice.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    AttributeRepository attributeRepository;
    @Override
    public Attributes save(Attributes attributes) {
        return attributeRepository.save(attributes);
    }

    @Override
    public List<Attributes> findAll() {
        List<Attributes> attributesList=new ArrayList<>();
        Iterable<Attributes> iterable= attributeRepository.findAll();
        for (Attributes a:iterable
             ) {
            attributesList.add(a);

        }
        return attributesList;
    }
    @Override
    public Attributes findById(String id){
        return attributeRepository.findById(id).get();
    }
}
