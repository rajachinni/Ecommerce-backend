package com.example.merchant.respository;

import com.example.merchant.collections.Merchant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MerchantRepository extends MongoRepository<Merchant,String> {


}
