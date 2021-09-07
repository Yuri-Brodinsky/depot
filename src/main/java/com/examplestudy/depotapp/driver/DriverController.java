package com.examplestudy.depotapp.driver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/drivers")
public class DriverController {
    private final DriverService service;
    public DriverController(DriverService service){
        this.service = service;
    }
    @GetMapping
    public List<Driver> getAll(){
        return service.findAll();
    }
}
