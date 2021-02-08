package com.example.attributeservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("attribute")
public class Attributes{
    @Id
    private String key;
    private ArrayList<String> value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<String> getValue() {
        return value;
    }

    public void setValue(ArrayList<String> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}