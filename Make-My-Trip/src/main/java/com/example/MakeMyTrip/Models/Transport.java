package com.example.MakeMyTrip.Models;

import com.example.MakeMyTrip.Enums.ModeOfTransport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transport")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer transportId;

    @Enumerated(value = EnumType.STRING)
    private ModeOfTransport modeOfTransport;

    private LocalDate journeyDate;

    private LocalTime startTime;

    private Double journeyTime;

    private String companyName;

    @ManyToOne
    @JoinColumn
    private Routes route;

    @OneToMany(mappedBy = "transport",cascade = CascadeType.ALL)
    private List<Seat> seatList=new ArrayList<>();

    @OneToMany(mappedBy = "transport",cascade = CascadeType.ALL)
    private List<Booking>bookingList=new ArrayList<>();
}
