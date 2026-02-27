package com.cinevault.bookingservice.Controller;
import com.cinevault.bookingservice.Service.AnalyticsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/revenue/movie/{movieTitle}")
    public Double revenueByMovie(@PathVariable String movieTitle) {
        return analyticsService.getRevenueByMovie(movieTitle);
    }

    @GetMapping("/most-booked-movie")
    public List<Object[]> mostBookedMovie() {
        return analyticsService.findMostBookedMovies();
    }

    @GetMapping("/revenue/day")
    public List<Object[]> revenuePerDay() {
        return analyticsService.getRevenuePerDay();
    }
}