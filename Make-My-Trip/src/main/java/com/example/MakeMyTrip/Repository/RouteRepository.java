package com.example.MakeMyTrip.Repository;

import com.example.MakeMyTrip.Enums.City;
import com.example.MakeMyTrip.Enums.ModeOfTransport;
import com.example.MakeMyTrip.Models.Routes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Routes,Integer> {
    List<Routes> findRoutesByFromCityAndToCityAndModeOfTransport(City fromCity, City toCity, ModeOfTransport modeOfTransport);
}
