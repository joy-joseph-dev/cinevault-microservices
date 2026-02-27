package com.cinevault.theaterservice.Service;
import com.cinevault.theaterservice.Entity.Theater;
import com.cinevault.theaterservice.Repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    public Theater getTheaterById(int id) {
        return theaterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theater not found"));
    }

    public Theater updateTheater(int id, Theater updated) {
        Theater theater = getTheaterById(id);
        theater.setName(updated.getName());
        theater.setCity(updated.getCity());
        theater.setAddress(updated.getAddress());
        return theaterRepository.save(theater);
    }

    public void deleteTheater(int id) {
        theaterRepository.deleteById(id);
    }
}