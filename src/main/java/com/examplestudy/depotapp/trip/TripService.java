package com.examplestudy.depotapp.trip;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    private final TripRepository repository;
    public TripService(TripRepository repository){
        this.repository = repository;
    }
    public List<Trip> findAll(){
        return repository.findAll();
    }
    public Trip getById(Long id){
        return repository.findById(id).get();
    }
    public void add(Trip trip){
        repository.save(trip);
    }
    public void update(Trip trip){
        Optional<Trip> raw = repository.findById(trip.getId());
        if(raw.isPresent()){
            Trip item = new Trip();
            item.setId(trip.getId());
            item.setBus(trip.getBus());
            item.setDriver(trip.getDriver());
            item.setRoute(trip.getRoute());
            item.setDate(trip.getDate());
            item.setDepartureTime(trip.getDepartureTime());
            item.setTicketsSale(trip.getTicketsSale());
            repository.save(item);
        }
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}
