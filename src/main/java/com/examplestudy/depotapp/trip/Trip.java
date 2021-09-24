package com.examplestudy.depotapp.trip;

import com.examplestudy.depotapp.Route.Route;
import com.examplestudy.depotapp.bus.Bus;
import com.examplestudy.depotapp.driver.Driver;
import com.examplestudy.depotapp.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.time.LocalTime;

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
    private LocalTime departureTime;
    @ManyToMany(fetch = FetchType.EAGER )
    @JoinTable(
            name = "users_trips",
            joinColumns = @JoinColumn(name="trip_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")

    )
    private Set<User> users;
    public void addUser(User user){
        users.add(user);
    }
    public void removeUser(User user){users.remove(user);}
    public Trip(Route route, LocalDate date, Bus bus, Driver driver, int ticketsSale, LocalTime departureTime){
        this.route = route;
        this.date = date;
        this.bus = bus;
        this.driver = driver;
        this.ticketsSale = ticketsSale;
        this.departureTime = departureTime;
    }



}