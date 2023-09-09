package com.example.MakeMyTrip.Repository;

import com.example.MakeMyTrip.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
    @Query(value = "select * from booking where journey_date=:journeyDataInput and transport_id=:transportIdInput",nativeQuery = true)
    List<Booking>findBooking(LocalDate journeyDataInput, Integer transportIdInput);

   // List<Booking>findBookingByTransportIdAndJourneyDate(LocalDate journeyDataInput, Integer transportIdInput);
}
