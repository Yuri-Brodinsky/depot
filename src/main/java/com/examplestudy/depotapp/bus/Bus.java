package com.examplestudy.depotapp.bus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name="number")
    private String number;
    @Column(name="model")
    private String model;
    @Column(name="capacity")
    private int capacity;
    @Column(name="consumption")
    private int consumption;
    @Column(name="costPerKilometer")
    private int costPerKilometer;
    @Column(name="comissioningDate")
    private LocalDate comissioningDate;
    public Bus(String number,String model,int capacity,
               int consumption,int costPerKilometer,LocalDate comissioningDate){
        this.number = number;
        this.model = model;
        this.capacity = capacity;
        this.consumption = consumption;
        this.comissioningDate = comissioningDate;
    }



}