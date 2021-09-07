package com.examplestudy.depotapp.Route;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/routes")
public class RouteController {
    private final RoutService service;
    public RouteController(RoutService service){
        this.service = service;
    }
    @GetMapping
    public List<Route> getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Route getById(@PathVariable Long id){
        return service.getById(id);
    }
    @PostMapping("/new")
    public void add(@RequestBody Route route){
        service.add(route);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Route route){
        service.update(route);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
