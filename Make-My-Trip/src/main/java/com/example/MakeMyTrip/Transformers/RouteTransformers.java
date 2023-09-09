package com.example.MakeMyTrip.Transformers;

import com.example.MakeMyTrip.Models.Routes;
import com.example.MakeMyTrip.requestDTO.AddRouteDTO;

public class RouteTransformers {

    public static Routes convertDtoToEntity(AddRouteDTO addRouteDTO){

        Routes routeObject=Routes.builder().
                fromCity(addRouteDTO.getFromCity())
                .toCity(addRouteDTO.getToCity())
                .listOfStopBetween(addRouteDTO.getStopsInBetween())
                .modeOfTransport(addRouteDTO.getModeOfTransport())
                .build();
        return routeObject;
    }
}
