package com.cinevault.bookingservice.Service;

import com.cinevault.bookingservice.DTO.BookingRequestDTO;
import com.cinevault.bookingservice.DTO.BookingResponseDTO;
import com.cinevault.bookingservice.DTO.SeatResponse;
import com.cinevault.bookingservice.DTO.ShowResponseDTO;
import com.cinevault.bookingservice.Entity.Booking;
import com.cinevault.bookingservice.Entity.BookingSeat;
import com.cinevault.bookingservice.Exception.BadRequestException;
import com.cinevault.bookingservice.Exception.ResourceNotFoundException;
import com.cinevault.bookingservice.Repository.BookingRepository;
import com.cinevault.bookingservice.Repository.BookingSeatRepository;
import com.cinevault.bookingservice.client.ShowServiceClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private BookingSeatRepository bookingSeatRepository;
    private ShowServiceClient showServiceClient;

    public BookingService(BookingRepository bookingRepository, BookingSeatRepository bookingSeatRepository,
                          ShowServiceClient showServiceClient) {
        this.bookingRepository = bookingRepository;
        this.bookingSeatRepository = bookingSeatRepository;
        this.showServiceClient = showServiceClient;

    }

    public BookingResponseDTO createBooking(BookingRequestDTO request) {


        List<SeatResponse> seatResponses = new ArrayList<>();

        for (Long seatId : request.getSeatIds()) {

            SeatResponse seat = showServiceClient.getSeatById(seatId);

            if (seat == null) {
                throw new ResourceNotFoundException("Seat not found with id: " + seatId);
            }

            if (seat.isBooked()) {
                throw new BadRequestException("Seat already booked: " + seat.getSeatNumber());
            }

            seatResponses.add(seat);
        }
        ShowResponseDTO showResponse = showServiceClient.getShowById(request.getShowId());

        if (showResponse == null) {
            throw new ResourceNotFoundException("Show not found with id: " + request.getShowId());
        }

        LocalDateTime showDateTime = LocalDateTime.of(
               showResponse.getShowDate(),
                showResponse.getShowTime()
        );


        double totalAmount = calculatePrice(seatResponses,showDateTime);


        Booking booking = new Booking();
        booking.setUserId(request.getUserId());
        booking.setUserName(request.getUserName());
        booking.setShowId(request.getShowId());
        booking.setMovieTitle(request.getMovieTitle());
        booking.setBookingTime(LocalDateTime.now());
        booking.setTotalAmount(totalAmount);

        Booking savedBooking = bookingRepository.save(booking);


        for (Long seatId : request.getSeatIds()) {

            showServiceClient.markSeatAsBooked(seatId);

            BookingSeat seat = new BookingSeat();
            seat.setBookingId(savedBooking.getId());
            seat.setSeatId(seatId);

            bookingSeatRepository.save(seat);
        }

        return new BookingResponseDTO(
                savedBooking.getId(),
                savedBooking.getUserName(),
                savedBooking.getMovieTitle(),
                savedBooking.getBookingTime(),
                savedBooking.getTotalAmount(),
                request.getSeatIds()
        );
    }

    public List<Booking> getBookingsByUserId(Long userId) {

        List<Booking> bookings = bookingRepository.findByUserId(userId);

        if (bookings.isEmpty()) {
            throw new ResourceNotFoundException("No bookings found for user");
        }

        return bookings;
    }

    private double calculatePrice(List<SeatResponse> seats, LocalDateTime showTime) {

        double total = 0;

        for (SeatResponse seat : seats) {

            double seatPrice = seat.getPrice();

            if (seat.getSeatType().equalsIgnoreCase("VIP")) {
                seatPrice *= 1.5;
            }
            else if (seat.getSeatType().equalsIgnoreCase("PREMIUM")) {
                seatPrice *= 1.2;
            }

            total += seatPrice;
        }


        if (showTime.getDayOfWeek().getValue() >= 6) {
            total *= 1.2;
        }

        if (showTime.getHour() < 12) {
            total *= 0.9;
        }

        return total;
    }
}