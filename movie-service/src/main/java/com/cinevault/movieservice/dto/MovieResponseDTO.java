package com.cinevault.movieservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class MovieResponseDTO {
    private final Long id;
    private final String title;
    private final String description;
    private final long duration;
    private final String language;
    private final LocalDate releaseDate;
    private final String genre;

}
