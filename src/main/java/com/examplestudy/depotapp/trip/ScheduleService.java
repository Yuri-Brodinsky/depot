package com.examplestudy.depotapp.trip;

import com.examplestudy.depotapp.route.Route;
import com.examplestudy.depotapp.user.User;
import com.examplestudy.depotapp.user.UserService;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class ScheduleService {
    private final TripService tripService;
    private final UserService userService;

    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addPassenger(Long tripId){
        Trip trip = tripService.findById(tripId);
        User user = userService.getUser();
        trip.addUser(user);
        trip.setTicketsSale(trip.getTicketsSale()+1);
        user.addTrip(trip);
        tripService.update(trip);
        userService.update(user);
    }
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void removePassenger(Long tripId){
        Trip trip = tripService.findById(tripId);
        User user = userService.getUser();
        trip.removeUser(user);
        trip.setTicketsSale(trip.getTicketsSale()-1);
        user.remove(trip);
        tripService.update(trip);
        userService.update(user);
    }

    public List<ScheduleTrip> findAllByRouteAndDate(Route route, LocalDate date){
        if(route==null||date==null) return List.of();
        return tripService.findAllByRouteAndDate(route,date).stream()
                .map(ScheduleTrip::getScheduleTripFromTrip)
                .collect(Collectors.toList());
    }
    public ScheduleTrip findById(Long id){
        return ScheduleTrip.getScheduleTripFromTrip(tripService.findById(id));
    }

}
