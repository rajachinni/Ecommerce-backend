package com.example.Inventory.services.impl;


import com.example.Inventory.entity.Inventory;
import com.example.Inventory.repository.InventoryRepository;
import com.example.Inventory.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InventoryServiceImpl  implements InventoryService {


    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Inventory save(Inventory inventory) {

        return inventoryRepository.save(inventory);
    }


    @Override
    @Transactional
    public void setPrice(String productId, String merchantId,double price) {
        inventoryRepository.setPrice(productId,merchantId,price);
    }

    @Override
    public int getStock(String productId){
        return inventoryRepository.getStock(productId);
    }

    @Override
    public void setQuantity(String productId, String merchantId, int quantity) {
        inventoryRepository.setQuantity(productId,merchantId,quantity);
    }


    @Override
    public List<Inventory> findByProductId(String productId) {

        return inventoryRepository.findByProductId(productId);
    }


    @Override
    public int getPrice(String productId){
        return inventoryRepository.getPrice(productId);
    }

    @Override
    public List<Inventory> findByMerchantId(String merchantId) {

        return inventoryRepository.findByMerchantId(merchantId);
    }


    @Override
    public double getSpecificPrice(String productId,String merchantId){

        return inventoryRepository.getSpecificPrice(productId,merchantId);
    }


    @Override
    public int getSpecificQuantity(String productId,String merchantId)
    {
        return inventoryRepository.getSpecificQuantity(productId,merchantId);
    }

}
