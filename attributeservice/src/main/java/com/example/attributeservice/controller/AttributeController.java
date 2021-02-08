package com.example.attributeservice.controller;

import com.example.attributeservice.entity.Attributes;
import com.example.attributeservice.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/attribute")
public class AttributeController {
    @Autowired
    AttributeService attributeService;

    @PostMapping(value = "/add")
    Attributes save(@RequestBody Attributes attributes){
        return attributeService.save(attributes);
    }
    @GetMapping(value = "/findAll")
    List<Attributes> findAll(){
        return attributeService.findAll();
    }
    @GetMapping(value = "/findById/{id}")
    Attributes findById(@PathVariable("id") String id){
        return attributeService.findById(id);
    }
}
