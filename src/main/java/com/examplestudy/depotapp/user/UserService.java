package com.examplestudy.depotapp.user;

import com.examplestudy.depotapp.response.NotFoundException;
import com.examplestudy.depotapp.security.UserDetailsImpl;
import com.examplestudy.depotapp.trip.ScheduleTrip;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository){ this.repository = repository;}

    private Long getId(){
          UserDetailsImpl userDetailsImpl = (UserDetailsImpl) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return userDetailsImpl.getId();
    }

    public User getUser(){
        User user = repository.findById(getId()).get();
        return user;
    }
    public User getAccount(){
        User user = getUser();
        user.setPassword(null);
        user.setTrips(null);
        return user;
    }
    public void update(User user) {
        Optional<User> optional = repository.findById(user.getId());
        if(optional.isPresent()&&optional.get().getId()==getId()){
            repository.save(user);
        }
        else throw new NotFoundException("no such trip found for update");


    }
   public List<ScheduleTrip> getAllTripsForUser(){
       return getUser().getTrips().stream()
               .map(ScheduleTrip::getScheduleTripFromTrip)
               .collect(Collectors.toList());

   }
}
