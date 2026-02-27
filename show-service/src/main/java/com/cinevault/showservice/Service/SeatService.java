package com.cinevault.showservice.Service;
import com.cinevault.showservice.Entity.Seat;
import com.cinevault.showservice.Repository.SeatRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public List<Seat> getSeatByShow(Long showId) {
        return seatRepository.findByShowId(showId);
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }
    public void markSeatAsBooked(Long seatId) {

        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));

        if (seat.isBooked()) {
            throw new RuntimeException("Seat already booked");
        }

        seat.setBooked(true);
        seatRepository.save(seat);
    }
    public Seat getSeatById(Long seatId) {

        return seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
    }
}