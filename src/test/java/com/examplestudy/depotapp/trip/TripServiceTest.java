package com.examplestudy.depotapp.trip;

import com.examplestudy.depotapp.response.NotFoundException;
import com.examplestudy.depotapp.route.Route;
import com.examplestudy.depotapp.route.RouteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TripServiceTest {
    @Mock
    private TripRepository repository;

    @Test

    public void shouldThrowNotFoundException(){
        when(repository.findById(3L)).thenReturn(Optional.empty());
        TripService service = new TripService(repository);
        Throwable thrown = Assertions.assertThrows(NotFoundException.class,
                ()->service.findById(3L));
        Assertions.assertEquals("no such trip found",thrown.getMessage());
    }
    @Test
    public void shouldNotThrowNotFoundException(){
        when(repository.findById(2L)).thenReturn(Optional.of(new Trip()));
        TripService service = new TripService(repository);
        Assertions.assertDoesNotThrow(()->service.findById(2L));
    }
    @Test
    public void shouldCallSave(){
        Trip trip = new Trip();
        trip.setId(2L);
        when(repository.findById(2L)).thenReturn(Optional.of(trip));
        TripService service = new TripService(repository);
        service.update(trip);
        verify(repository,times(1)).save(trip);
    }


}