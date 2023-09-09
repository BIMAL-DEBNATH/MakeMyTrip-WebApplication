package com.example.MakeMyTrip.Transformers;

import com.example.MakeMyTrip.Models.Booking;
import com.example.MakeMyTrip.requestDTO.MakeBookingDto;

public class BookingTransformers {

    public static Booking convertRequestToEntity(MakeBookingDto makeBookingDto){

        Booking booking=Booking.builder()
                .seatNos(makeBookingDto.getSeatNos())
                .journeyDate(makeBookingDto.getJourneyDate())
                .transportId(makeBookingDto.getTransportId())
                .build();

        return booking;
    }
}
