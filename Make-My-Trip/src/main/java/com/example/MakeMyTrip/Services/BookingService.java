package com.example.MakeMyTrip.Services;

import com.example.MakeMyTrip.Models.*;
import com.example.MakeMyTrip.Repository.BookingRepository;
import com.example.MakeMyTrip.Repository.TransportRepository;
import com.example.MakeMyTrip.Repository.UserRepository;
import com.example.MakeMyTrip.ResponseDTO.AvailableSeatResponseDto;
import com.example.MakeMyTrip.Transformers.BookingTransformers;
import com.example.MakeMyTrip.requestDTO.GetAvailableSeatDto;
import com.example.MakeMyTrip.requestDTO.MakeBookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class BookingService {
    @Autowired
   private BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
   private TransportRepository transportRepository;
    public List<AvailableSeatResponseDto> getAvailableSeat(GetAvailableSeatDto entryDto) {

        List<Booking>doneBooking=bookingRepository.findBooking(entryDto.getJourneyDate(), entryDto.getTransportId());

        Set<String> BookedSeats=new TreeSet<>();

        for(Booking booking:doneBooking){
            String seats=booking.getSeatNos();//1E,2B,3E..
            String[]bookedSeatsInThisBooking=seats.split(",");

            for(String seat:bookedSeatsInThisBooking){
                BookedSeats.add(seat);
            }
        }

        List<Seat>seatList=transportRepository.findById(entryDto.getTransportId()).get().getSeatList();

     //TotalSeats-bookedSeats

        List<AvailableSeatResponseDto>finalAvailableSeats=new ArrayList<>();

        for(Seat seat:seatList){

            if(BookedSeats.contains(seat.getSeatNo())){
                continue;
            }else {
                AvailableSeatResponseDto availableSeats=AvailableSeatResponseDto.builder()
                        .seatNo(seat.getSeatNo())
                        .seatType(seat.getSeatType())
                        .seatPrice(seat.getPrice())
                        .build();
                finalAvailableSeats.add(availableSeats);
            }
        }

          return  finalAvailableSeats;
    }

    public String makeABook(MakeBookingDto makeBookingDto) {

        User userObj=userRepository.findById(makeBookingDto.getUserId()).get();
        Transport transportObj=transportRepository.findById(makeBookingDto.getTransportId()).get();
        Booking booking= BookingTransformers.convertRequestToEntity(makeBookingDto);
        TicketEntity ticket=makeTicketEntity(transportObj,makeBookingDto);
        //Fk key
        booking.setUser(userObj);
        booking.setTransport(transportObj);
        booking.setTicketEntity(ticket);


        //Bidirectional mapping

        userObj.getBookingList().add(booking);
        transportObj.getBookingList().add(booking);
        ticket.setBooking(booking);

        bookingRepository.save(booking);

        return "Booking has been added successfully and give Ticket!";

    }

    private TicketEntity makeTicketEntity(Transport transport,MakeBookingDto makeBookingDto){


        Integer totalPricePaid=getTotalPricePaid(transport, makeBookingDto.getSeatNos());

        String routeDetails=getRouteDetails(transport);

       TicketEntity ticket=TicketEntity.builder()
               .journeyDate(makeBookingDto.getJourneyDate())
               .allSeatNo(makeBookingDto.getSeatNos())
               .startTime(transport.getStartTime())
               .routeDetails(routeDetails)
               .totalCost(totalPricePaid)
               .build();


       return ticket;

    }

    private String getRouteDetails(Transport transport){
        Routes routes=transport.getRoute();
        String ans=routes.getFromCity()+" TO "+routes.getToCity();
        return  ans;
    }

    private Integer getTotalPricePaid(Transport transport, String seatsToBooked){

        List<Seat>seatList=transport.getSeatList();

        int total=0;

        String st[]=seatsToBooked.split(",");
        TreeSet<String>set=new TreeSet<>();
        for(String str:st){
            set.add(str);
        };

        for(Seat seat:seatList){
            if(set.contains(seat.getSeatNo())){
                total+=seat.getPrice();
                set.remove(seat.getSeatNo());
            }
        }

       return total;
    }
}
