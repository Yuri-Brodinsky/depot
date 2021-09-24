package com.examplestudy.depotapp.trip;

import com.examplestudy.depotapp.Route.Route;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/schedule")
public class ScheduleController {
    private final ScheduleService service;
    public ScheduleController(ScheduleService service){
        this.service = service;
    }

    @GetMapping
    public List<ScheduleTrip> getAllByRouteAndDate(Route route, LocalDate date){
        return service.getScheduleByRouteAndDate(route,date);
    }
    @GetMapping("/{id}")
    public ScheduleTrip getByRouteAndDate(@PathVariable Long id){
        return service.getOneById(id);
    }
    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('clients')")
    public String addOrder(@PathVariable Long id){
        service.addPassenger(id);
        return "Thanks for order!";
    }
    @DeleteMapping ("/{id}")
    @PreAuthorize("hasAuthority('clients')")
    public String removeOrder(@PathVariable Long id){
        service.removePassenger(id);
        return "Your order has been canceled!";
    }

}
