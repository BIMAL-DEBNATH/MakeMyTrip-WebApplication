package com.example.MakeMyTrip.requestDTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetAvailableSeatDto {
    LocalDate journeyDate;
    int transportId;
}
