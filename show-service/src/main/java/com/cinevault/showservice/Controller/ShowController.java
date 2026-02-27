package com.cinevault.showservice.Controller;

import com.cinevault.showservice.Entity.Show;
import com.cinevault.showservice.Service.ShowService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping
    public Show create(@RequestBody Show show) {
        return showService.createShow(show);
    }

    @GetMapping
    public List<Show> getAll() {
        return showService.getAllShows();
    }

    @GetMapping("/{id}")
    public Show getById(@PathVariable Long id) {
        return showService.getShowById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        showService.deleteShow(id);
    }
}