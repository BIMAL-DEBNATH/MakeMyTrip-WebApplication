package com.example.MakeMyTrip.Controllers;

import com.example.MakeMyTrip.ResponseDTO.FlightResult;
import com.example.MakeMyTrip.Services.TransportService;
import com.example.MakeMyTrip.requestDTO.AddTransportDTO;
import com.example.MakeMyTrip.requestDTO.SearchFlightDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j //for log
@RequestMapping("transport")
public class TransportControllers {
    @Autowired
    TransportService transportService;

    @PostMapping("/add")
    public ResponseEntity<String> addTransport(@RequestBody AddTransportDTO addTransportDTO){


          try {
              String res=transportService.addTransport(addTransportDTO);
              return new ResponseEntity<>(res, HttpStatus.CREATED);
          }catch (Exception e){
              log.error("Add transport failed{}",e.getMessage());
              return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
          }
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightResult>>searchFlight(@RequestBody SearchFlightDTO searchFlightDTO){

        List<FlightResult>flightResults=transportService.searchFlight(searchFlightDTO);
        return new ResponseEntity<>(flightResults,HttpStatus.FOUND);
    }



}
