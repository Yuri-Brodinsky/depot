package com.examplestudy.depotapp.user;


import com.examplestudy.depotapp.trip.ScheduleTrip;

import lombok.Data;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/account")
public class UserController {
    private final UserService service;

    public UserController(UserService service){ this.service = service;}

    @GetMapping
    @PreAuthorize("hasAuthority('clients')")
    public User get(){
        return service.getAccount();
    }
    @GetMapping("/orders")
    @PreAuthorize("hasAuthority('clients')")
    public List<ScheduleTrip> getOrders(){
        return service.getAllTripsForUser();
    }
}
