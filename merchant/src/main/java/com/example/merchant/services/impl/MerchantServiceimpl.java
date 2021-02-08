package com.example.merchant.services.impl;

import com.example.merchant.collections.Merchant;
import com.example.merchant.respository.MerchantRepository;
import com.example.merchant.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantServiceimpl implements MerchantService {

      @Autowired
      MerchantRepository merchantRepository;

    @Override
    public Merchant save(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant findById(String merchantId) {
        return merchantRepository.findById(merchantId).get();
    }

    @Override
    public List<String> findOrders(String merchantId) {

        Iterable<String> orderIterable = merchantRepository.findById(merchantId).get().getOrderId();
        List<String> orderList = new ArrayList<>();
        orderIterable.forEach(orderList::add);
        return orderList;
    }

    @Override
    public void addMerchantOrder(String merchantId, String orderId) {
        Merchant merchant = merchantRepository.findById(merchantId).get();
        merchant.setOrderId(orderId);
        merchantRepository.save(merchant);

    }
}
