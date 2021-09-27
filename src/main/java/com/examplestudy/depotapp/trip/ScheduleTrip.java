package com.examplestudy.depotapp.trip;

import com.examplestudy.depotapp.route.Route;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleTrip {
    private Long id;
    private String route;
    private String departureTime;
    private String arrivalTime;
    private int cost;
    private int tickets;
    public static ScheduleTrip getScheduleTripFromTrip(Trip trip){
        Route route = trip.getRoute();
        return new ScheduleTrip(
                trip.getId(),
                new StringBuilder(route.getFrom()).append(" ").append(route.getTo()).toString(),
                trip.getDepartureTime().toString(),
                //route.getTimeTravel().getMinute())
                (trip.getDepartureTime().plusMinutes(200)).toString(),
                route.getPathLength()*trip.getBus().getCostPerKilometer(),
                trip.getTicketsSale()
        );
    }
}
