package com.example.productmicroservice.controller;

import com.example.productmicroservice.entity.Product;
import com.example.productmicroservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping(value = "/getproduct/{productId}")
    Product findProduct(@PathVariable("productId") String productId){
        Product p = productService.findById(productId);
        //System.out.println(p);
        return p;
    }


    @GetMapping(value = "/getallproducts")
    List<Product> findProduct(){
        List<Product> p =productService.findAll();
        //System.out.println(p);
        return p;
    }


    @PostMapping(value = "/addproduct")
    Product save(@RequestBody Product product){


        return productService.save(product);


    }

    @PostMapping(value = "/addImage/{productId}/{url}")
    String addImage(@PathVariable("productId")String productId,@PathVariable("url")String url)
    {
        Product product =  productService.findById(productId);
        //product.setImages();
        return "success";
    }

//    @GetMapping(value="/getMerchants/{productId}")
//    List<String> getMerchants(@PathVariable String id){
//        return productService.getMerchants(id);
//    }


//    @GetMapping(value = "/getStock/{productId}")
//    int getStock(@PathVariable("productId") String id){
//        return productService.getStock(id);
//    }



}
