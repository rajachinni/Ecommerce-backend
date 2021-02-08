package com.example.demorating.controller;

import com.example.demorating.entity.Rating;
import com.example.demorating.entity.RatingCollection;
import com.example.demorating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value="/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @GetMapping
    String getCalled() {
        return "working";
    }

    @GetMapping(value = ("/get/{id}"))
    Rating getRatingById(@PathVariable("id") String id) {
        return ratingService.getRating(id);
    }

    @PostMapping(value = "/setavg/{id}")
    String setAvgRatingById(@PathVariable("id") String id, double avg){
        return ratingService.setAvgRatingById(id,avg);
    }

    @PostMapping(value = "/save/{id}")
    String setRatingById(@PathVariable("id") String id, @RequestBody RatingCollection ratingCollection) {

        List<RatingCollection> avg;
        ratingService.setRating(id, ratingCollection);
        Rating rating=ratingService.getRating(id);
        avg=rating.getRatingCollectionList();
        double sum=0.0;
        for(int i=0;i<avg.size();i++)
            sum+=avg.get(i).getRating();
        sum+=ratingCollection.getRating();
        double avgRating=sum/(avg.size()+1);
        return ratingService.setAvgRatingById(id, avgRating);
    }

    @GetMapping(value = "/findAll")
    List<String> findAll(){
        List<Rating> ratings;
        List<String> sortedIds=new ArrayList<>();
        ratings=ratingService.findAll();
        Collections.sort(ratings);
        for(int i=0;i<ratings.size();i++)
            sortedIds.add(ratings.get(i).getProductId());
        return sortedIds;
    }
}