package com.cinevault.bookingservice.DTO;

import lombok.Data;

@Data
public class SeatResponse {

    private Long id;
    private String seatNumber;
    private String seatType;
    private int price;
    private boolean booked;
}