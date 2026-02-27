package com.cinevault.theaterservice.Controller;
import com.cinevault.theaterservice.Entity.Screen;
import com.cinevault.theaterservice.Service.ScreenService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/screens")
public class ScreenController {

    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @PostMapping
    public Screen create(@RequestBody Screen screen) {
        return screenService.createScreen(screen);
    }

    @GetMapping
    public List<Screen> getAll() {
        return screenService.getAllScreens();
    }

    @GetMapping("/{id}")
    public Screen getById(@PathVariable int id) {
        return screenService.getScreenById(id);
    }

    @PutMapping("/{id}")
    public Screen update(@PathVariable int id, @RequestBody Screen screen) {
        return screenService.updateScreen(id, screen);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        screenService.deleteScreen(id);
    }
}