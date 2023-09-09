package com.example.MakeMyTrip.Services;

import com.example.MakeMyTrip.Enums.SeatType;
import com.example.MakeMyTrip.Models.Seat;
import com.example.MakeMyTrip.Models.Transport;
import com.example.MakeMyTrip.Repository.SeatRepository;
import com.example.MakeMyTrip.Repository.TransportRepository;
import com.example.MakeMyTrip.requestDTO.AddFlightSeatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    TransportRepository transportRepository;
    public String addFlightSeat(AddFlightSeatDTO SeatDTO) {

        Transport transport=transportRepository.findById(SeatDTO.getTransportID()).get();

        for(int i=1; i<=SeatDTO.getNumberOfEconomySeat(); i++){
            Seat seat=Seat.builder()
                    .seatNo(String.valueOf(i+"E"))
                    .seatType(SeatType.ECONOMY)
                    .price(SeatDTO.getPriceOfEconomySeat())
                    .transport(transport)
                    .build();
             //this is because of bidirectional mapping setting parent class also;
            transport.getSeatList().add(seat);

        }

        for(int i=1; i<=SeatDTO.getNumberOfBusinessSeat(); i++){
            Seat seat=Seat.builder()
                    .seatNo(String.valueOf(i+"B"))
                    .seatType(SeatType.BUSINESS)
                    .price(SeatDTO.getPriceOfBusinessSeat())
                    .transport(transport)
                    .build();
            //this is because of bidirectional mapping setting parent class also;
            transport.getSeatList().add(seat);

        }

        transportRepository.save(transport);

        return "Defined seat has been created";

    }
}
