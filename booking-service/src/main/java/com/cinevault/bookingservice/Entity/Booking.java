package com.cinevault.bookingservice.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String userName;   // snapshot

    private Long showId;
    private String movieTitle; // snapshot
    private LocalDate showDate;   // snapshot
    private LocalTime showTime;   // snapshot

    private LocalDateTime bookingTime;

    private double totalAmount;
}