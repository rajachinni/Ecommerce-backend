package com.example.merchant.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Merchant {

    @Id
    private String  merchantId;
    private String  merchantName;
    private String  password;
    private String  gstPin;
    private double   rating;
    private List<String> orderId = new ArrayList<>();

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGstPin() {
        return gstPin;
    }

    public void setGstPin(String gstPin) {
        this.gstPin = gstPin;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId.add(orderId);
    }
}
