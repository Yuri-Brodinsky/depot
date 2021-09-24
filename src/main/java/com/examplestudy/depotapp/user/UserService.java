package com.examplestudy.depotapp.user;

import com.examplestudy.depotapp.security.SecurityUser;
import com.examplestudy.depotapp.trip.ScheduleService;
import com.examplestudy.depotapp.trip.ScheduleTrip;
import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class UserService {
    private final UserRepository repository;
    private final ScheduleService service;

    private Long getId(){
          SecurityUser securityUser = (SecurityUser) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return securityUser.getId();
    }

    public User getUser(){
        User user = repository.findById(getId()).get();
        user.setPassword(null);
        user.setTrips(null);
        return user;
    }
   public List<ScheduleTrip> getAllTripsForUser(){
        return service.getAllTripsForUser(getId());
   }

}
