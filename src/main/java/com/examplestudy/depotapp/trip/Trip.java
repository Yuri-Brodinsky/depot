package com.examplestudy.depotapp.trip;

import com.examplestudy.depotapp.route.Route;
import com.examplestudy.depotapp.bus.Bus;
import com.examplestudy.depotapp.driver.Driver;
import com.examplestudy.depotapp.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="route_id")
    private Route route;
    @Column(name="date")
    private LocalDate date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bus_id")
    private Bus bus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="driver_id")
    private Driver driver;
    @Column(name="ticket_sale")
    private int ticketsSale;
    @Column(name="departure_time")
    private LocalTime departureTime;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_trips",
            joinColumns = @JoinColumn(name="trip_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")

    )
    private Set<User> users;

    public Trip(Route route, LocalDate date, Bus bus, Driver driver,
                int ticketsSale, LocalTime departureTime){
        this.route = route;
        this.date = date;
        this.bus = bus;
        this.driver = driver;
        this.ticketsSale = ticketsSale;
        this.departureTime = departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(id, trip.id) && Objects.equals(route, trip.route)
                && Objects.equals(date, trip.date) && Objects.equals(bus, trip.bus)
                && Objects.equals(departureTime, trip.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, route, date, bus, departureTime);
    }

    @Override
    public String toString(){
        return new StringBuilder()
                .append(" route: ")
                .append(route)
                .append(" date: ")
                .append(date)
                .append(" departure_time: ")
                .append(departureTime)
                .toString();
    }
}