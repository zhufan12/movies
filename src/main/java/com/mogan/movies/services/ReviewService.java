package com.mogan.movies.services;

import com.mogan.movies.dto.CreateReviewDTO;
import com.mogan.movies.entity.Review;

public interface ReviewService {

    public Review createReview(CreateReviewDTO createReviewDTO);
}
