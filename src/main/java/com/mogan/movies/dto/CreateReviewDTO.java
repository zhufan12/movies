package com.mogan.movies.dto;


import lombok.Data;

@Data
public class CreateReviewDTO {

    private String imdbId;

    private String reviewBody;
}
