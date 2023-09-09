package com.example.MakeMyTrip.Transformers;

import com.example.MakeMyTrip.Models.Transport;
import com.example.MakeMyTrip.ResponseDTO.FlightResult;
import com.example.MakeMyTrip.requestDTO.AddTransportDTO;

public class TransportTransformer {
    public static Transport convertDtoToEntity(AddTransportDTO addTransportDTO){

        Transport transportObject=Transport.builder()
                .modeOfTransport(addTransportDTO.getModeOfTransport())
                .journeyDate(addTransportDTO.getJourneyDate())
                .startTime(addTransportDTO.getStartTime())
                .journeyTime(addTransportDTO.getJourneyTime())
                .companyName(addTransportDTO.getCompanyName())
                .build();
        return transportObject;
    }

    public static FlightResult convertEntityToFlightResult(Transport transport){

        FlightResult flightResult=FlightResult.builder()
                .journeyDate(transport.getJourneyDate())
                .startTime(transport.getStartTime())
                .journeyTime(transport.getJourneyTime())
                .companyName(transport.getCompanyName())
                .build();
        return flightResult;
    }
}
