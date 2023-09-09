package com.example.MakeMyTrip.Services;

import com.example.MakeMyTrip.Enums.ModeOfTransport;
import com.example.MakeMyTrip.Exceptions.RouteNotFound;
import com.example.MakeMyTrip.Models.Routes;
import com.example.MakeMyTrip.Models.Transport;
import com.example.MakeMyTrip.Repository.RouteRepository;
import com.example.MakeMyTrip.Repository.TransportRepository;
import com.example.MakeMyTrip.ResponseDTO.FlightResult;
import com.example.MakeMyTrip.Transformers.TransportTransformer;
import com.example.MakeMyTrip.requestDTO.AddTransportDTO;
import com.example.MakeMyTrip.requestDTO.SearchFlightDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransportService {
    @Autowired
    TransportRepository transportRepository;
    @Autowired
    RouteRepository routeRepository;
    public String addTransport(AddTransportDTO addTransportDTO) throws Exception{

        Transport transportObj= TransportTransformer.convertDtoToEntity(addTransportDTO);

        //Setting the foreign key entity

        Optional<Routes>optionalRoutes=routeRepository.findById(addTransportDTO.getRouteId());

        if(!optionalRoutes.isPresent()){
            throw new RouteNotFound("RouteId is not valid");
        }

        Routes routes=optionalRoutes.get();

        //FK that we are setting
        transportObj.setRoute(routes);

        //Bidirectional mapping also need to taken care of
        routes.getTransportList().add(transportObj);

        routeRepository.save(routes);
        return "Transport has been added successfully";
    }

    public List<FlightResult> searchFlight(SearchFlightDTO searchFlightDTO) {

        List<Routes>routesList=routeRepository.findRoutesByFromCityAndToCityAndModeOfTransport(searchFlightDTO.getFromCity(),searchFlightDTO.getToCity(), ModeOfTransport.FLIGHT);

        List<FlightResult>flightResults=new ArrayList<>();

        for(Routes routes:routesList){

            for(Transport transport:routes.getTransportList()){

                if(transport.getJourneyDate().equals(searchFlightDTO.getJourneyDate())){
                    FlightResult create=TransportTransformer.convertEntityToFlightResult(transport);
                    create.setListOfStopsInBetween(routes.getListOfStopBetween());
                    flightResults.add(create);
                }
            }
        }

        return flightResults;
    }




}
