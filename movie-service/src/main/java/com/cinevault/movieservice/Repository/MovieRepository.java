package com.cinevault.movieservice.Repository;
import com.cinevault.movieservice.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitleContainingIgnoreCase(String keyword);

    List<Movie> findByGenreIgnoreCase(String genre);
}