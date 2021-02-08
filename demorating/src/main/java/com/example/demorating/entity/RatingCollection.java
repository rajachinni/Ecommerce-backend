package com.example.demorating.entity;

public class RatingCollection {
    private double rating;
    private String customerId;
    private String review;

    public RatingCollection() {

    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getReview() {
        return review;
    }
}
