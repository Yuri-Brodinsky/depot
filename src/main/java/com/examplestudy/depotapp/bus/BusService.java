package com.examplestudy.depotapp.bus;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusService {
    private final BusRepository repository;
    public BusService(BusRepository repository){
        this.repository = repository;
    }
    public List<Bus> findAll(){
        return repository.findAll();
    }
}
