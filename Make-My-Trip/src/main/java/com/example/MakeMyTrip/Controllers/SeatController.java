package com.example.MakeMyTrip.Controllers;

import com.example.MakeMyTrip.Services.SeatService;
import com.example.MakeMyTrip.requestDTO.AddFlightSeatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    SeatService seatService;
    @PostMapping("add")
    public String addFlightSeat(@RequestBody AddFlightSeatDTO addFlightSeatDTO){
     return seatService.addFlightSeat(addFlightSeatDTO);
    }

}
