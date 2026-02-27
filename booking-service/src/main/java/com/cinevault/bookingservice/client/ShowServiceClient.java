package com.cinevault.bookingservice.client;

import com.cinevault.bookingservice.DTO.SeatResponse;
import com.cinevault.bookingservice.DTO.ShowResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "show-service")
public interface ShowServiceClient {

    @GetMapping("/seats/details/{seatId}")
    SeatResponse getSeatById(@PathVariable Long seatId);

    @PutMapping("/seats/{seatId}/book")
    void markSeatAsBooked(@PathVariable Long seatId);

    @GetMapping("/shows/{id}")
    ShowResponseDTO getShowById(@PathVariable("id") Long id);
}