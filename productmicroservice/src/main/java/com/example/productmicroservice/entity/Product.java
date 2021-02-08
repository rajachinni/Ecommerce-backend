package com.example.productmicroservice.entity;


import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Product")
public class Product {

    private String _id;
    private String name;
    private String category;
    private int stock;
    private Attributes[] attribute;
    private String[] images;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getProductId() {
        return _id;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Attributes[] getAttribute() {
        return attribute;
    }

    public void setAttribute(Attributes[] attribute) {
        this.attribute = attribute;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + _id + '\'' +"productname="+name+
                ", category='" + category + '\'' +
                ", stock=" + stock +
                ", attribute='" + attribute + '\'' +
                '}';
    }


}
