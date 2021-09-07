package com.examplestudy.depotapp.driver;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    private final DriverRepository repository;
    public DriverService(DriverRepository repository){
        this.repository = repository;
    }
    public List<Driver> findAll(){
        return repository.findAll();
    }
    public Driver findById(Long id){
        return repository.findById(id).get();
    }
    public void add(Driver driver){
        repository.save(driver);
    }
    public void update(Driver driver){
        Optional<Driver> row = repository.findById(driver.getId());
        if(row.isPresent()){
            Driver item = row.get();
            item.setId(driver.getId());
            item.setName(driver.getName());
            item.setLastName(driver.getLastName());
            item.setBirthYear(driver.getBirthYear());
            item.setEmploymentDate(driver.getEmploymentDate());
            repository.save(item);

        }
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}
