package com.example.MakeMyTrip.Services;

import com.example.MakeMyTrip.Models.Routes;
import com.example.MakeMyTrip.Repository.RouteRepository;
import com.example.MakeMyTrip.Transformers.RouteTransformers;
import com.example.MakeMyTrip.requestDTO.AddRouteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    @Autowired
    RouteRepository routeRepository;
    public String addRoutes(AddRouteDTO addRouteDTO) {

       // Routes route=new Routes();
        Routes routesObject= RouteTransformers.convertDtoToEntity(addRouteDTO);
        routeRepository.save(routesObject);

        return "Route has been added successfully!";
    }
}
