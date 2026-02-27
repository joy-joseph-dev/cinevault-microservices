package com.cinevault.movieservice.Controller;

import com.cinevault.movieservice.Service.MovieService;
import com.cinevault.movieservice.dto.MovieRequestDTO;
import com.cinevault.movieservice.dto.MovieResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieResponseDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public MovieResponseDTO addMovie(@RequestBody MovieRequestDTO dto) {
        return movieService.addMovie(dto);
    }

    @PutMapping("/{id}")
    public MovieResponseDTO updateMovie(@PathVariable Long id,
                                        @RequestBody MovieRequestDTO dto) {
        return movieService.updateMovie(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @GetMapping("/search")
    public List<MovieResponseDTO> searchMovies(@RequestParam String keyword) {
        return movieService.searchMovies(keyword);
    }

    @GetMapping("/genre")
    public List<MovieResponseDTO> getByGenre(@RequestParam String genre) {
        return movieService.getByGenre(genre);
    }
}