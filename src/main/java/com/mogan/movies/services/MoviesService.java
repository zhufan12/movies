package com.mogan.movies.services;

import com.mogan.movies.entity.Movie;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface MoviesService {
    public List<Movie> getAllMovies();

    public Optional<Movie> getMovieById(String imdbId);
}
