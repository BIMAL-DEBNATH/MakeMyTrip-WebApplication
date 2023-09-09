package com.example.MakeMyTrip.Controllers;

import com.example.MakeMyTrip.Services.RouteService;
import com.example.MakeMyTrip.requestDTO.AddRouteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("route")
public class RouteController {
    @Autowired
    RouteService routeService;
    @PostMapping("/add")
    public String addRoutes(@RequestBody AddRouteDTO addRouteDTO){
        return routeService.addRoutes(addRouteDTO);
    }
}
