package com.example.MakeMyTrip.requestDTO;

import lombok.Data;

@Data
public class AddFlightSeatDTO {
    private int numberOfEconomySeat;
    private int numberOfBusinessSeat;
    private  int priceOfEconomySeat;
    private int priceOfBusinessSeat;
    private int transportID;
}
