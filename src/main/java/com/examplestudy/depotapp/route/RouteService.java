package com.examplestudy.depotapp.route;

import com.examplestudy.depotapp.response.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {
    private final RouteRepository repository;

    public RouteService(RouteRepository repository) { this.repository = repository;}

    public List<Route> findAll(){
        return repository.findAll();
    }
    public Route findById(Long id){
        Optional<Route> optional = repository.findById(id);
        if(optional.isEmpty()) throw new NotFoundException("no such route found");
        return optional.get();
    }
    public void add(Route route){
        repository.save(route);
    }
    public void update(Route route){
        Optional<Route> optional = repository.findById(route.getId());
        if(optional.isPresent()){
            Route item = new Route();
            item.setId(route.getId());
            item.setFrom(route.getFrom());
            item.setTo(route.getTo());
            item.setPathLength(route.getPathLength());
            item.setTimeTravel(route.getTimeTravel());
            repository.save(item);
        }
        else throw new NotFoundException("no such route found for update");
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}
