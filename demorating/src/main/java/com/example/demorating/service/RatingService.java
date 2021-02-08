package com.example.demorating.service;

import com.example.demorating.entity.Rating;
import com.example.demorating.entity.RatingCollection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    String setRating(String productId, RatingCollection ratingCollection);
    Rating getRating(String productId);
    List<Rating> findAll();
    String setAvgRatingById(String id, double avg);
}
