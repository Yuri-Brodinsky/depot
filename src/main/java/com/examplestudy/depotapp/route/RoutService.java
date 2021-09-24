package com.examplestudy.depotapp.route;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutService {
    private final RouteRepository repository;
    public RoutService(RouteRepository repository){
        this.repository = repository;
    }
    public List<Route> findAll(){
        return repository.findAll();
    }
    public Route getById(Long id){
        return repository.findById(id).get();
    }
    public void add(Route route){
        repository.save(route);
    }
    public void update(Route route){
        Optional<Route> row = repository.findById(route.getId());
        if(row.isPresent()){
            Route item = new Route();
            item.setId(route.getId());
            item.setFrom(route.getFrom());
            item.setTo(route.getTo());
            item.setPathLength(route.getPathLength());
            item.setTimeTravel(route.getTimeTravel());
            repository.save(item);
        }
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}
