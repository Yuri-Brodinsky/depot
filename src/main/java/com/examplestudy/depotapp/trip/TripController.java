package com.examplestudy.depotapp.trip;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/trips")
public class TripController {
    private final TripService service;
    public TripController(TripService service){
        this.service = service;
    }
    @GetMapping
    public List<Trip> getAll(){
        return service.findAll();
    }
}
