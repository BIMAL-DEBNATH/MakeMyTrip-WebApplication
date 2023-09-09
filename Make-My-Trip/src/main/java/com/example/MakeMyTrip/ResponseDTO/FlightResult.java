package com.example.MakeMyTrip.ResponseDTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
public class FlightResult {
    private LocalDate journeyDate;
    private LocalTime startTime;
    private Double journeyTime;
    private String companyName;
    private String listOfStopsInBetween;
}
