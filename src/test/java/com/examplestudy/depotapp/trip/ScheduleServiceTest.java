package com.examplestudy.depotapp.trip;

import com.examplestudy.depotapp.user.User;
import com.examplestudy.depotapp.user.UserService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ScheduleServiceTest {
    //@Mock
    private TripService tripService = mock(TripService.class,RETURNS_DEEP_STUBS);
    //@Mock
    private UserService userService = mock(UserService.class,RETURNS_DEEP_STUBS);;
    private static User user;
    private static Trip trip;
    @BeforeAll
    public static void  init(){
        user = new User();
        user.setTrips(new HashSet<Trip>());
        trip = new Trip();
        trip.setUsers(new HashSet<User>());
    }

    @Test
    public void shouldAddInSet(){
        when(tripService.findById(2L)).thenReturn(trip);
        when(userService.getUser()).thenReturn(user);
        ScheduleService service = new ScheduleService(tripService,userService);
        service.addPassenger(2L);
        Assertions.assertEquals(1,user.getTrips().size());
        Assertions.assertEquals(1,trip.getUsers().size());
        verify(userService,times(1)).update(user);
        verify(tripService,times(1)).update(trip);
    }
    @Test
    public void shouldCallMethod(){
        when(tripService.findById(2L)).thenReturn(trip);
        when(userService.getUser()).thenReturn(user);
        ScheduleService service = new ScheduleService(tripService,userService);
        service.addPassenger(2L);
        Assertions.assertEquals(1,user.getTrips().size());
        Assertions.assertEquals(1,trip.getUsers().size());
    }

}