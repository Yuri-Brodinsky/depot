package com.examplestudy.depotapp.Route;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutService {
    private final RouteRepository repository;
    public RoutService(RouteRepository repository){
        this.repository = repository;
    }
    public List<Route> findAll(){
        return repository.findAll();
    }
}
