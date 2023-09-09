package com.example.MakeMyTrip.ResponseDTO;

import com.example.MakeMyTrip.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvailableSeatResponseDto {
    private String seatNo;
    private SeatType seatType;
    private  int seatPrice;
}
