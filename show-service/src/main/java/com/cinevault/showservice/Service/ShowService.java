package com.cinevault.showservice.Service;

import com.cinevault.showservice.Entity.Show;
import com.cinevault.showservice.Repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public Show createShow(Show show) {
        return showRepository.save(show);
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show getShowById(Long id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));
    }

    public void deleteShow(Long id) {
        showRepository.deleteById(id);
    }
}