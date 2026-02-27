package com.cinevault.bookingservice.Service;
import com.cinevault.bookingservice.Repository.BookingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnalyticsService {

    private final BookingRepository bookingRepository;

    public AnalyticsService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Double getRevenueByMovie(String movieTitle) {
        return bookingRepository.getTotalRevenueByMovie(movieTitle);
    }

    public List<Object[]> findMostBookedMovies() {
        return bookingRepository.findMostBookedMovies();
    }

    public List<Object[]> getRevenuePerDay() {
        return bookingRepository.getRevenuePerDay();
    }
}