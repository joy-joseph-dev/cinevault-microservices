package com.cinevault.theaterservice.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int screenNumber;
    private int totalSeats;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;
}