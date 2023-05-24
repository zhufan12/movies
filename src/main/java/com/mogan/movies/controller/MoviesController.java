package com.mogan.movies.controller;


import com.mogan.movies.entity.Movie;
import com.mogan.movies.services.MoviesService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping
    public ResponseEntity<List<Movie>> allMovies(){
        List<Movie> movies = moviesService.getAllMovies();
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Movie> getMovie(@PathVariable("imdbId")  String imdbId){
        Optional<Movie> movie = moviesService.getMovieById(imdbId);
        if(!movie.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie.get());
    }
}
