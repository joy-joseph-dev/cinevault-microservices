package com.cinevault.bookingservice.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class BookingResponseDTO {

    private final Long bookingId;
    private final String userName;
    private final String movieTitle;
    private final LocalDateTime bookingTime;
    private final double totalAmount;
    private final List<Long> seatIds;
}