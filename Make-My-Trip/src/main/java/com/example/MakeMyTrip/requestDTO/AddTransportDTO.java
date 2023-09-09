package com.example.MakeMyTrip.requestDTO;

import com.example.MakeMyTrip.Enums.ModeOfTransport;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class AddTransportDTO {
    private ModeOfTransport modeOfTransport;

    private LocalDate journeyDate;

    private LocalTime startTime;

    private Double journeyTime;

    private Integer routeId;

    private String companyName;
}
