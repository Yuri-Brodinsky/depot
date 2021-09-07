package com.examplestudy.depotapp.bus;

import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public Bus getById(@PathVariable Long id) {
        return service.findById(id);
    }
    @PostMapping("/new")
    public void add(@RequestBody Bus bus){
        service.add(bus);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Bus bus){
        service.update(bus);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
