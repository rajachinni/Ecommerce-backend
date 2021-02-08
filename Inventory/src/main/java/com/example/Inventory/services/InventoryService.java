package com.example.Inventory.services;

import com.example.Inventory.entity.Inventory;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface InventoryService {

    Inventory save(Inventory inventory);
    void setPrice(String productId,String merchantId,double price);
    void setQuantity(String productId,String merchantId,int quantity);
    int getStock(String productId);
    List<Inventory> findByProductId(String productId);
    int  getPrice(String productId);
    List<Inventory> findByMerchantId(String merchantId);
    double getSpecificPrice(String productId,String merchantId);
    int getSpecificQuantity(String productId,String merchantId);
}
