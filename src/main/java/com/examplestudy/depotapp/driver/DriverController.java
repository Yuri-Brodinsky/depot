package com.examplestudy.depotapp.driver;

import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public Driver getById(@PathVariable Long id){
       return service.findById(id);
    }
    @PostMapping("/new")
    public void add(@RequestBody Driver driver){
        service.add(driver);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Driver driver){
        service.update(driver);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
