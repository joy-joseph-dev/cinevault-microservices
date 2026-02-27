package com.cinevault.bookingservice.Controller;

import com.cinevault.bookingservice.DTO.BookingRequestDTO;
import com.cinevault.bookingservice.DTO.BookingResponseDTO;
import com.cinevault.bookingservice.Entity.Booking;
import com.cinevault.bookingservice.Service.BookingService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingResponseDTO createBooking(@RequestBody BookingRequestDTO request) {
        return bookingService.createBooking(request);
    }
    @GetMapping("/user/{userId}")
    public List<Booking>getBookings(@PathVariable Long userId){
        return bookingService.getBookingsByUserId(userId);
    }
}