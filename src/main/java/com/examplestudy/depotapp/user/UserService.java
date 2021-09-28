package com.examplestudy.depotapp.user;

import com.examplestudy.depotapp.security.SecurityUser;
import com.examplestudy.depotapp.trip.ScheduleService;
import com.examplestudy.depotapp.trip.ScheduleTrip;
import com.examplestudy.depotapp.trip.Trip;
import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class UserService {

    private final UserRepository repository;

    private Long getId(){
          SecurityUser securityUser = (SecurityUser) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return securityUser.getId();
    }

    public User getUser(){
        User user = repository.findById(getId()).get();
        user.setPassword(null);
        return user;
    }
    public void update(User user) {
        repository.save(user);
    }
   public List<ScheduleTrip> getAllTripsForUser(){
       return getUser().getTrips().stream()
               .map(ScheduleTrip::getScheduleTripFromTrip)
               .collect(Collectors.toList());

   }
}
