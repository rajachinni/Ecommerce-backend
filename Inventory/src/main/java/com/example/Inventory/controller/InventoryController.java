package com.example.Inventory.controller;
import com.example.Inventory.entity.Inventory;
import com.example.Inventory.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/Inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;


    @PostMapping(value="/save")
    Inventory save(@RequestBody Inventory inventory){

        return inventoryService.save(inventory);

    }

    @PostMapping(value="/price/{productId}/{merchantId}/{price}")
    void setPrice(@PathVariable("productId")String productId,@PathVariable("merchantId")String merchantId,@PathVariable("price")double price){
        inventoryService.setPrice(productId,merchantId,price);
    }

    @PostMapping(value="/quantity/{productId}/{merchantId}/{quantity}")
    void setQuantity(@PathVariable("productId")String productId,@PathVariable("merchantId")String merchantId,@PathVariable("quantity")int quantity){
        inventoryService.setQuantity(productId,merchantId,quantity);
    }


    @GetMapping(value="/allStock/{productId}")
    int  getstock(@PathVariable("productId")String productId) {

        return inventoryService.getStock(productId);
    }

    @GetMapping(value="/findProduct/{productId}")
    List<Inventory> findProductById(@PathVariable String productId){

                return inventoryService.findByProductId(productId);

    }

    @GetMapping(value="/findPrice/{productId}")
    int getPrice(@PathVariable("productId")String productId){

        return inventoryService.getPrice(productId);
    }

    @GetMapping(value="/findProducts/{merchantId}")
    List<Inventory> findByMerchantId(@PathVariable("merchantId")String merchantId) {
        return inventoryService.findByMerchantId(merchantId);
    }


    @GetMapping(value="/findSpecificPrice/{productId}/{merchantId}")
    double getSpecificPrice(@PathVariable("productId") String productId,@PathVariable("merchantId") String merchantId){

        return inventoryService.getSpecificPrice(productId,merchantId);
    }

    @GetMapping(value="/findSpecificQuantity/{productId}/{merchantId}")
    int getSpecificQuantity(@PathVariable("productId") String productId,@PathVariable("merchantId") String merchantId)
    {
        return inventoryService.getSpecificQuantity(productId,merchantId);
    }

    @GetMapping(value="/decQuantity/{productId}/{merchantId}/{quantity}")
    String decQuantity(@PathVariable("productId") String productId,@PathVariable("merchantId")String merchantId,@PathVariable("quantity")Integer quantity){

        inventoryService.setQuantity(productId,merchantId,(inventoryService.getSpecificQuantity(productId,merchantId)-quantity));

        return "done decreased";
    }

}
