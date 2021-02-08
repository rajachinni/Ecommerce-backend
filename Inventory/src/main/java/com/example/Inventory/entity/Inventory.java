package com.example.Inventory.entity;

import javax.persistence.*;

@Entity
@Table(name="inventory")
public class Inventory  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    /*@EmbeddedId
    private InventoryId inventoryId;*/
    private String productId;
    private String merchantId;
    private double price;
    private int    quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
