package com.examplestudy.depotapp.Route;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
