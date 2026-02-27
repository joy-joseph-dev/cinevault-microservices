package com.cinevault.showservice.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="shows")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate showDate;
    private LocalTime showTime;
    private double basePrice;

    private Long movieId;   // instead of @ManyToOne Movie
    private Long screenId;  // instead of @ManyToOne Screen
}