package com.examplestudy.depotapp.bus;

import com.examplestudy.depotapp.response.AlreadyExistException;
import com.examplestudy.depotapp.response.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {
    private final BusRepository repository;

    public BusService(BusRepository repository){this.repository = repository;}

    public List<Bus> findAll(){
        return repository.findAll();
    }
    public Bus findById(Long id){
        Optional<Bus> optional = repository.findById(id);
        if(optional.isEmpty()) throw new NotFoundException("no such bus found");
        return optional.get();

    }
    public void add(Bus bus){
        Optional<Bus> optional = repository.findByNumber(bus.getNumber());
        if(optional.isPresent()) throw new AlreadyExistException("bus with same number is already exist");
        repository.save(bus);
    }
    public void update(Bus bus){
        Optional<Bus> optional = repository.findById(bus.getId());
        if(optional.isPresent()){
            Bus item = optional.get();
            item.setId(bus.getId());
            item.setNumber(bus.getNumber());
            item.setModel(bus.getModel());
            item.setCapacity(bus.getCapacity());
            item.setConsumption(bus.getConsumption());
            item.setCostPerKilometer(bus.getCostPerKilometer());
            item.setComissioningDate(bus.getComissioningDate());
            repository.save(item);
        }
        else throw new NotFoundException("no such bus found for update");
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}
