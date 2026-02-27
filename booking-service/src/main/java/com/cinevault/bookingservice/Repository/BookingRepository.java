package com.cinevault.bookingservice.Repository;

import com.cinevault.bookingservice.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("""
SELECT b.movieTitle, COUNT(b)
FROM Booking b
GROUP BY b.movieTitle
ORDER BY COUNT(b) DESC
""")
    List<Object[]> findMostBookedMovies();

    @Query("""
SELECT DATE(b.bookingTime), SUM(b.totalAmount)
FROM Booking b
GROUP BY DATE(b.bookingTime)
""")
    List<Object[]> getRevenuePerDay();

    @Query("""
SELECT SUM(b.totalAmount)
FROM Booking b
WHERE b.movieTitle = :movieTitle
""")
    Double getTotalRevenueByMovie(@Param("movieTitle") String movieTitle);

    List<Booking> findByUserId(Long userId);
}