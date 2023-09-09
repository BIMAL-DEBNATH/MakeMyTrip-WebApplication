package com.example.MakeMyTrip.requestDTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MakeBookingDto {
    private String seatNos;
    private LocalDate journeyDate;
    private Integer transportId;
    private  Integer userId;
}
