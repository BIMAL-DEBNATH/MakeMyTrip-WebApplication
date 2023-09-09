package com.example.MakeMyTrip.Repository;

import com.example.MakeMyTrip.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
