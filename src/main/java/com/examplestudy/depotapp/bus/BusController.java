package com.examplestudy.depotapp.bus;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("api/v1/buses")
@PreAuthorize("hasAuthority('depot')")
public class BusController {
    private final BusService service;
    public BusController(BusService service){
        this.service = service;
    }
    @GetMapping
    @PreAuthorize("hasAuthority('depot')")
    public List<Bus> getAll() {
        return service.findAll();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('depot')")
    public Bus getById(@PathVariable Long id) {
        return service.findById(id);
    }
    @PostMapping("/new")
    @PreAuthorize("hasAuthority('depot')")
    public void add(@RequestBody Bus bus){
        service.add(bus);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('depot')")
    public void update(@RequestBody Bus bus){
        service.update(bus);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('depot')")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
