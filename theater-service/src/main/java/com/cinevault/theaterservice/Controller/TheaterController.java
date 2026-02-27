package com.cinevault.theaterservice.Controller;
import com.cinevault.theaterservice.Entity.Theater;
import com.cinevault.theaterservice.Service.TheaterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaters")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @PostMapping
    public Theater create(@RequestBody Theater theater) {
        return theaterService.createTheater(theater);
    }

    @GetMapping
    public List<Theater> getAll() {
        return theaterService.getAllTheaters();
    }

    @GetMapping("/{id}")
    public Theater getById(@PathVariable int id) {
        return theaterService.getTheaterById(id);
    }

    @PutMapping("/{id}")
    public Theater update(@PathVariable int id, @RequestBody Theater theater) {
        return theaterService.updateTheater(id, theater);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        theaterService.deleteTheater(id);
    }
}