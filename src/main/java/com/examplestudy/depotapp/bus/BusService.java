package com.examplestudy.depotapp.bus;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {
    private final BusRepository repository;
    public BusService(BusRepository repository){
        this.repository = repository;
    }
    public List<Bus> findAll(){
        return repository.findAll();
    }
    public Bus findById(Long id){
        return repository.findById(id).get();
    }
    public void add(Bus bus){
        repository.save(bus);
    }
    public void update(Bus bus){
        Optional<Bus> row = repository.findById(bus.getId());
        if(row.isPresent()){
            Bus item = row.get();
            item.setId(bus.getId());
            item.setNumber(bus.getNumber());
            item.setModel(bus.getModel());
            item.setCapacity(bus.getCapacity());
            item.setConsumption(bus.getConsumption());
            item.setCostPerKilometer(bus.getCostPerKilometer());
            item.setComissioningDate(bus.getComissioningDate());
            repository.save(item);

        }
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}
