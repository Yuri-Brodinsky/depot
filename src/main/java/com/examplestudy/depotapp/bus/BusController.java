package com.examplestudy.depotapp.bus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("v1/buses")
public class BusController {
    private final BusService service;
    public BusController(BusService service){
        this.service = service;
    }
    @GetMapping
    public List<Bus> getAll() {
        return service.findAll();
    }
}
