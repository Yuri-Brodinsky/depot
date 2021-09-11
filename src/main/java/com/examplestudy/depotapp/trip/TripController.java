package com.examplestudy.depotapp.trip;

import com.examplestudy.depotapp.user.User;
import com.examplestudy.depotapp.user.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/trips")
public class TripController {
    private final TripService service;
    public TripController(TripService service){
        this.service = service;
    }
    @GetMapping
    @PreAuthorize("hasAuthority('depot')")
    public List<Trip> getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Trip getById(@PathVariable Long id){
        return service.getById(id);
    }
    @PostMapping("/new")
    public void add(@RequestBody Trip trip){
        service.add(trip);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Trip trip){
        service.update(trip);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
    @PostMapping("/v1/{id}/buy")
    public void addOrder(@PathVariable Long id){
      service.addPassenger(id);
    }


}
