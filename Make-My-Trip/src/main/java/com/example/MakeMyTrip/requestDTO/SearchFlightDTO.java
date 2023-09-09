package com.example.MakeMyTrip.requestDTO;

import com.example.MakeMyTrip.Enums.City;
import lombok.Data;

import java.time.LocalDate;
@Data
public class SearchFlightDTO {
    private City fromCity;
    private City toCity;
    private LocalDate journeyDate;
}
