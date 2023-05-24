package com.mogan.movies.services.impl;

import com.mogan.movies.entity.Movie;
import com.mogan.movies.repository.MoviesRepository;
import com.mogan.movies.services.MoviesService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesServiceImpl implements MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public List<Movie> getAllMovies() {
        return moviesRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(String imdbId) {
        return moviesRepository.findMovieByImdbId(imdbId);
    }
}
