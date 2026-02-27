package com.cinevault.theaterservice.Service;


import com.cinevault.theaterservice.Entity.Screen;
import com.cinevault.theaterservice.Repository.ScreenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenService(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    public Screen createScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    public Screen getScreenById(int id) {
        return screenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Screen not found"));
    }

    public Screen updateScreen(int id, Screen updated) {
        Screen screen = getScreenById(id);
        screen.setScreenNumber(updated.getScreenNumber());
        screen.setTotalSeats(updated.getTotalSeats());
        return screenRepository.save(screen);
    }

    public void deleteScreen(int id) {
        screenRepository.deleteById(id);
    }
}