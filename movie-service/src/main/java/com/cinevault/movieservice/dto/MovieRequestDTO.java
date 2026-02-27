package com.cinevault.movieservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MovieRequestDTO {

    private String title;
    private String description;
    private long duration;
    private String language;
    private LocalDate releaseDate;
    private String genre;
}