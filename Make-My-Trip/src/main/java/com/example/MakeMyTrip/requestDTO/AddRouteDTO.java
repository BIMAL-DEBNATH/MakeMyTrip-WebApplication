package com.example.MakeMyTrip.requestDTO;

import com.example.MakeMyTrip.Enums.City;
import com.example.MakeMyTrip.Enums.ModeOfTransport;
import lombok.Data;

@Data
public class AddRouteDTO {

    private City fromCity;

    private City toCity;

    private String stopsInBetween;

    private ModeOfTransport modeOfTransport;
}
