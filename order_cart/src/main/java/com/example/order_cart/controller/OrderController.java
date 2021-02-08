package com.example.order_cart.controller;

import com.example.order_cart.entity.CartEntity;
import com.example.order_cart.entity.OrderEntity;
import com.example.order_cart.entity.ProductEntity;
import com.example.order_cart.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/saveOrder")
    String saveOrder(@RequestBody OrderEntity orderEntity){
        return  orderService.saveOrder(orderEntity);

    }

    @GetMapping(value = "/getOrder/{customerEmail}")
    List<OrderEntity> getOrder(@PathVariable("customerEmail") String customerEmail){
        return orderService.getOrder(customerEmail);
    }



    @PostMapping(value="/altsave")
    OrderEntity altsaveOrder(@RequestBody OrderEntity orderEntity){

        return orderService.getOrderById(orderService.saveOrder(orderEntity));

    }

    @GetMapping(value="/getOrderById/{orderId}")
    OrderEntity getOrderById(@PathVariable("orderId")String orderId)
    {
        return orderService.getOrderById(orderId);
    }

   //@PostMapping(value=/setTotalPrice/{orderId})

    @GetMapping(value = "/getCart/{customerEmail}")
    CartEntity getCart(@PathVariable("customerEmail") String customerEmail){
        return orderService.getCart(customerEmail);
    }

    @PutMapping(value = "/updateCart/{customerEmail}")
    String updateCart(@RequestBody ProductEntity cart,@PathVariable("customerEmail") String customerEmail)
    {
        orderService.updateCart(cart,customerEmail);
        return "success";
    }

    @PostMapping(value = "/cart")
    String saveCart(@RequestBody CartEntity cart){

        orderService.saveCart(cart);
        return "posted";
    }

    @DeleteMapping(value = "/deleteCart/{customerEmail}")
    String deleteCart(@PathVariable("customerEmail") String customerEmail){
        orderService.deleteCart(customerEmail);
        return "deleted";
    }

    @GetMapping(value="/sendMail/{orderId}")
    String sendMail(@PathVariable("orderId")String orderId) throws Exception{
        //List<OrderEntity> orderList = new ArrayList<>();

        OrderEntity orderList=orderService.getOrderById(orderId);
        String email = orderList.getCustomerEmail();
        orderService.sendEmail(email,orderList);
        return "success";
    }
}
