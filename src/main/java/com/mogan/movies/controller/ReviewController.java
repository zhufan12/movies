package com.mogan.movies.controller;

import com.mogan.movies.dto.CreateReviewDTO;
import com.mogan.movies.entity.Movie;
import com.mogan.movies.entity.Review;
import com.mogan.movies.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
public class ReviewController {


    @Autowired
    private ReviewService reviewService;


    @PostMapping("/")
    public ResponseEntity<Review> createReview(@RequestBody CreateReviewDTO reviewDTO){
        Review review = reviewService.createReview(reviewDTO);
        return ResponseEntity.ok(review);
    }

}
