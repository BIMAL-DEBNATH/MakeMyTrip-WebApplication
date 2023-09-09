package com.example.MakeMyTrip.Controllers;

import com.example.MakeMyTrip.ResponseDTO.AvailableSeatResponseDto;
import com.example.MakeMyTrip.Services.BookingService;
import com.example.MakeMyTrip.requestDTO.GetAvailableSeatDto;
import com.example.MakeMyTrip.requestDTO.MakeBookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @GetMapping("getAvailableSeat")
    public ResponseEntity getAvailableSeat(@RequestBody GetAvailableSeatDto entryDto){
        List<AvailableSeatResponseDto> res = bookingService.getAvailableSeat(entryDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


   @PostMapping("/makeABook")
    public String makeABook(@RequestBody MakeBookingDto makeBookingDto){
        return bookingService.makeABook(makeBookingDto);
   }

   //cancel ticket;

}
