package com.cinevault.bookingservice.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class ShowResponseDTO {

   private Long id;
   private LocalDate showDate;
   private LocalTime showTime;
   private double basePrice;
   private Long movieId;
   private Long screenId;
}