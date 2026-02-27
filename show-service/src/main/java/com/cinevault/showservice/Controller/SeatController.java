package com.cinevault.showservice.Controller;

import com.cinevault.showservice.Entity.Seat;
import com.cinevault.showservice.Service.SeatService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping
    public Seat create(@RequestBody Seat seat) {
        return seatService.createSeat(seat);
    }

    @GetMapping("/{showId}")
    public List<Seat> getSeatByShow(@PathVariable Long showId) {
        return seatService.getSeatByShow(showId);
    }

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @PutMapping("/{seatId}/book")
    public void markSeatAsBooked(@PathVariable Long seatId) {
        seatService.markSeatAsBooked(seatId);
    }

    @GetMapping("/details/{seatId}")
    public Seat getSeatById(@PathVariable Long seatId) {
        return seatService.getSeatById(seatId);
    }
}