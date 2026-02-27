package com.cinevault.bookingservice.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingRequestDTO {

    private Long userId;
    private String userName;

    private Long showId;
    private String movieTitle;

    private List<Long> seatIds;
}