package com.examplestudy.depotapp.trip;

import com.examplestudy.depotapp.Route.Route;
import com.examplestudy.depotapp.bus.Bus;
import com.examplestudy.depotapp.driver.Driver;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="route_id")
    private Route route;
    @Column(name="date")
    private LocalDate date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="bus_id")
    private Bus bus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="driver_id")
    private Driver driver;
    @Column(name="ticketSale")
    private int ticketsSale;
    @Column(name="departure_time")
    private String departureTime;
    public Trip(Route route, LocalDate date, Bus bus, Driver driver, int ticketsSale, int hour, int min){
        this.route = route;
        this.date = date;
        this.bus = bus;
        this.driver = driver;
        this.ticketsSale = ticketsSale;
        setDepartureTime(hour,min);
    }
    public void setDepartureTime(int hour,int min){
        if(hour>=0&&hour<=23)departureTime=""+hour+" : ";
        else departureTime = "0 : ";
        if(min>=0&&min<=59) departureTime = departureTime+min;
        else departureTime = departureTime + "00";
    }


}