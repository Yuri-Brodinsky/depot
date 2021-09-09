package com.examplestudy.depotapp.trip;

import com.examplestudy.depotapp.Route.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
    List<Trip> findAllByRouteAndDate(Route route, LocalDate date);
}
