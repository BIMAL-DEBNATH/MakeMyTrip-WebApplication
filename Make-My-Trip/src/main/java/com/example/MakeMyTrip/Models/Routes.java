package com.example.MakeMyTrip.Models;

import com.example.MakeMyTrip.Enums.City;
import com.example.MakeMyTrip.Enums.ModeOfTransport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="route")
@Builder
@Data // Getter && Setter && RequireArgConstructor && toString
@AllArgsConstructor
@NoArgsConstructor
public class Routes {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer routeId;

    @Enumerated(value = EnumType.STRING)
    private City fromCity;

    @Enumerated(value = EnumType.STRING)
    private City toCity;

    private String  listOfStopBetween;

    @Enumerated(value = EnumType.STRING)
    private ModeOfTransport modeOfTransport;

    @OneToMany(mappedBy = "route",cascade = CascadeType.ALL)
    private List<Transport> transportList=new ArrayList<>();

}
