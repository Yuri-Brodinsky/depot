package com.examplestudy.depotapp.driver;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DriverService {
    private final DriverRepository repository;
    public DriverService(DriverRepository repository){
        this.repository = repository;
    }
    public List<Driver> findAll(){
        return repository.findAll();
    }
}
