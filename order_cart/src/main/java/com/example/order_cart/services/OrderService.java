package com.example.order_cart.services;

import com.example.order_cart.entity.CartEntity;
import com.example.order_cart.entity.OrderEntity;
import com.example.order_cart.entity.ProductEntity;

import java.util.List;

public interface OrderService {
    String saveOrder(OrderEntity orderEntity);
    List<OrderEntity> getOrder(String customerEmail);
    CartEntity getCart(String customerEmail);
//    void updateCart(CartEntity cartEntity);
    OrderEntity getOrderById(String orderId);
    void saveCart(CartEntity cart);
    void deleteCart(String customerEmail);
    String updateCart(ProductEntity productEntity, String customerId);
    void sendEmail(String email,OrderEntity orderList) throws Exception;
}
