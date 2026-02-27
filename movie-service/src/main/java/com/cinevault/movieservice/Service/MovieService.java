package com.cinevault.movieservice.Service;
import com.cinevault.movieservice.Repository.MovieRepository;
import com.cinevault.movieservice.dto.MovieRequestDTO;
import com.cinevault.movieservice.dto.MovieResponseDTO;
import com.cinevault.movieservice.entity.Movie;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieResponseDTO> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public MovieResponseDTO addMovie(MovieRequestDTO dto) {

        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        movie.setDuration(dto.getDuration());
        movie.setLanguage(dto.getLanguage());
        movie.setReleaseDate(dto.getReleaseDate());
        movie.setCreatedAt(LocalDate.now());
        movie.setGenre(dto.getGenre());

        Movie saved = movieRepository.save(movie);

        return mapToDTO(saved);
    }

    public MovieResponseDTO updateMovie(Long id, MovieRequestDTO dto) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        movie.setDuration(dto.getDuration());
        movie.setLanguage(dto.getLanguage());
        movie.setReleaseDate(dto.getReleaseDate());
        movie.setGenre(dto.getGenre());

        Movie updated = movieRepository.save(movie);

        return mapToDTO(updated);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public List<MovieResponseDTO> searchMovies(String keyword) {
        return movieRepository.findByTitleContainingIgnoreCase(keyword)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public List<MovieResponseDTO> getByGenre(String genre) {
        return movieRepository.findByGenreIgnoreCase(genre)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private MovieResponseDTO mapToDTO(Movie movie) {
        return new MovieResponseDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getDuration(),
                movie.getLanguage(),
                movie.getReleaseDate(),
                movie.getGenre()
        );
    }
}