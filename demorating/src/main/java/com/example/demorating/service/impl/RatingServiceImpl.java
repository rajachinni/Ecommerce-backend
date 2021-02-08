package com.example.demorating.service.impl;

import com.example.demorating.entity.Rating;
import com.example.demorating.entity.RatingCollection;
import com.example.demorating.repository.RatingRepository;
import com.example.demorating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepository ratingRepository;

    @Override
    public String setRating(String productId, RatingCollection ratingCollection) {

        try {

            Rating rating = ratingRepository.findById(productId).get();
            List<RatingCollection> ratingCollectionList = rating.getRatingCollectionList();
            ratingCollectionList.add(ratingCollection);
            rating.setRatingCollectionList(ratingCollectionList);
            ratingRepository.save(rating);
            return "saved";

        }catch (Exception exp)
        {
            System.out.println(exp.getMessage());
            try {
                Rating rating = new Rating();
                List<RatingCollection> ratingCollectionList = new ArrayList<>();
                RatingCollection ratingCollection1 = new RatingCollection();
                ratingCollection1.setRating(ratingCollection.getRating());
                ratingCollection1.setCustomerId(ratingCollection.getCustomerId());
                ratingCollection1.setReview(ratingCollection.getReview());

                ratingCollectionList.add(ratingCollection1);
                rating.setProductId(productId);

                rating.setRatingCollectionList(ratingCollectionList);
                ratingRepository.save(rating);
                return  "stored";

            }catch (Exception ex1)
            {
                System.out.println(ex1.getMessage());
                return  "error";
            }
        }
    }

    @Override
    public Rating getRating(String productId) {
        if(ratingRepository.findById(productId).get()!=null)
        return ratingRepository.findById(productId).get();
        else
            return null;
    }
    @Override
    public List<Rating> findAll(){
        return ratingRepository.findAll();
    }

    @Override
    public String setAvgRatingById(String id, double avg) {
        try {

            Rating rating = ratingRepository.findById(id).get();
            rating.setAvgRating(avg);
            ratingRepository.save(rating);

            return "saved";

        }catch (Exception exp)
        {
            System.out.println(exp.getMessage());
            try {
                Rating rating = new Rating();
                rating.setAvgRating(avg);
                ratingRepository.save(rating);
                return  "stored";

            }catch (Exception ex1)
            {
                System.out.println(ex1.getMessage());
                return  "eroor";
            }
        }
    }
}
