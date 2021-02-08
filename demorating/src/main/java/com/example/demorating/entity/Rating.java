package com.example.demorating.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document("ratings")
public class Rating implements Comparable<Rating>{
    @Id
    private String productId;
    private List<RatingCollection> ratingCollectionList = new ArrayList<>();
    private double avgRating;

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<RatingCollection> getRatingCollectionList() {
        return ratingCollectionList;
    }

    public void setRatingCollectionList(List<RatingCollection> ratingCollectionList) {
        this.ratingCollectionList = ratingCollectionList;
    }

    @Override
    public int compareTo(Rating u) {
        if (getAvgRating() == 0.0 || u.getAvgRating() == 0.0) {
            return 0;
        }
        return Double.compare(getAvgRating(), u.getAvgRating());
    }
}
