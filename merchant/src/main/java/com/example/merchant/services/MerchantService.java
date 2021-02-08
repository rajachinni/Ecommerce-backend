package com.example.merchant.services;

import com.example.merchant.collections.Merchant;

import java.util.List;

public interface MerchantService {

    Merchant save(Merchant merchant);
    Merchant findById(String merchantId);
    List<String> findOrders(String merchantId);
    void addMerchantOrder(String orderId,String MerchantId);


}
