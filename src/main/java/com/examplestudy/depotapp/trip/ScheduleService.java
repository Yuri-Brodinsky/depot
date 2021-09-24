package com.examplestudy.depotapp.trip;

import com.examplestudy.depotapp.Route.Route;
import com.examplestudy.depotapp.security.SecurityUser;
import com.examplestudy.depotapp.user.User;
import com.examplestudy.depotapp.user.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class ScheduleService {
    private final TripRepository repository;
    private final UserRepository userRepository;
    public ScheduleService(TripRepository repository,UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
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
    public List<ScheduleTrip> convertTrips(List<Trip> trips){
        return trips.stream()
                .map(ScheduleTrip::getTripInfoFromTrio)
                .collect(Collectors.toList());
    }
    public List<ScheduleTrip> getScheduleByRouteAndDate(Route route, LocalDate date){
        List<Trip> trips = null;
        if(route==null||date==null) return List.of();
        else trips = repository.findAllByRouteAndDate(route,date);
        return convertTrips(trips);
    }
    public ScheduleTrip getOneById(Long id){
        return ScheduleTrip.getTripInfoFromTrio(repository.findById(id).get());
    }
    public List<ScheduleTrip> getAllTripsForUser(Long id){
        User user = userRepository.findById(id).get();
        Set<Trip> set = user.getTrips();
        List<Trip> trips = new ArrayList<>(set);
        return convertTrips(trips);
    }
}
