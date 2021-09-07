package com.examplestudy.depotapp.trip;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    private final TripRepository repository;
    public TripService(TripRepository repository){
        this.repository = repository;
    }
    public List<Trip> findAll(){
        return repository.findAll();
    }
}
