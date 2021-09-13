package com.examplestudy.depotapp.trip;

import com.examplestudy.depotapp.Route.Route;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/schedule")
public class TripForPassengerController {
    private final TripService service;
    public TripForPassengerController(TripService service){
        this.service = service;
    }
    @GetMapping
    public List<TripForPassengers> tripForPassengers(){
        return service.getTripsForPassenger(null,null);
    }
    @PostMapping
    public List<TripForPassengers> tripForPassengers(Route route,LocalDate date){
        return service.getTripsForPassenger(route,date);
    }
    @PostMapping("/{id}/buy")
    @PreAuthorize("hasAuthority('clients')")
    public String addOrder(@PathVariable Long id){
        service.addPassenger(id);
        return "Thanks for order!";
    }
    @PostMapping("/{id}/cancel")
    @PreAuthorize("hasAuthority('clients')")
    public String removeOrder(@PathVariable Long id){
        service.removePassenger(id);
        return "Your order has been canceled!";
    }
}
