package com.mogan.movies.services.impl;

import com.mogan.movies.dto.CreateReviewDTO;
import com.mogan.movies.entity.Movie;
import com.mogan.movies.entity.Review;
import com.mogan.movies.repository.ReviewRepository;
import com.mogan.movies.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Review createReview(CreateReviewDTO createReviewDTO) {
        Review review = new Review();
        review.setBody(createReviewDTO.getReviewBody());
        reviewRepository.save(review);

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(createReviewDTO.getImdbId()))
                .apply(new Update().push("reviewIds").value(review)).first();

        return review;

    }
}
