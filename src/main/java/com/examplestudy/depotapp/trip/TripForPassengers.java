package com.examplestudy.depotapp.trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripForPassengers {
    private Long id;
    private String route;
    private String departureTime;
    private String arrivalTime;
    private int cost;
    private int tickets;
}
