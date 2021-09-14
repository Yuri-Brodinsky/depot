package com.examplestudy.depotapp.trip;

import com.examplestudy.depotapp.Route.Route;
import com.examplestudy.depotapp.security.SecurityUser;
import com.examplestudy.depotapp.security.User;
import com.examplestudy.depotapp.security.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TripService {
    private final TripRepository repository;
    private final UserRepository userRepository;
    public TripService(TripRepository repository,UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
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

    public List<Trip> findAllByRouteAndDate(Route route, LocalDate date){
        return repository.findAllByRouteAndDate(route,date);
    }

    public void addPassenger(Long tripId){
        Trip trip =repository.findById(tripId).get();
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        Long userId = securityUser.getId();
        User user = userRepository.findById(userId).get();
        trip.addUser(user);
        trip.setTicketsSale(trip.getTicketsSale()+1);
        user.addTrip(trip);
        repository.save(trip);
        userRepository.save(user);
    }
    public void removePassenger(Long tripId){
        Trip trip =repository.findById(tripId).get();
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        Long userId = securityUser.getId();
        User user = userRepository.findById(userId).get();
        trip.removeUser(user);
        trip.setTicketsSale(trip.getTicketsSale()-1);
        user.remove(trip);
        repository.save(trip);
        userRepository.save(user);
    }
    public List<TripForPassengers> convertTrips(List<Trip> trips){
        return trips.stream().map(e->new TripForPassengers(
                e.getId(),
                e.getRoute().toString(),
                e.getDepartureTime(),
                (""+e.getRoute().getTimeTravel()),
                e.getRoute().getPathLength()*e.getBus().getCostPerKilometer(),
                e.getBus().getCapacity()-e.getTicketsSale()

        )).collect(Collectors.toList());
    }
    public List<TripForPassengers> getTripsForPassengerByRouteAndData(Route route, LocalDate date){
        List<Trip> trips = null;
        if(route!=null&&date!=null) { trips = findAllByRouteAndDate(route,date);}
        else trips = repository.findAll();
        return convertTrips(trips);
    }
    public List<TripForPassengers> getAllTripsForPassenger(){
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        Long userId = securityUser.getId();
        User user = userRepository.findById(userId).get();
        Set<Trip> set = user.getTrips();
        List<Trip> trips = new ArrayList<>(set);
        return convertTrips(trips);
    }
}
