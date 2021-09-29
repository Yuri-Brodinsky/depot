package com.examplestudy.depotapp.route;

import com.examplestudy.depotapp.response.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class RouteServiceTest {
    @Mock
    private RouteRepository repository;
    @Test
    public void shouldThrowNotFoundException(){
        when(repository.findById(3L)).thenReturn(Optional.empty());
        RouteService service = new RouteService(repository);
        Throwable thrown =Assertions.assertThrows(NotFoundException.class,
                ()->service.findById(3L));
        Assertions.assertEquals("no such route found",thrown.getMessage());
    }
    @Test
    public void shouldNotThrowNotFoundException(){
        when(repository.findById(2L)).thenReturn(Optional.of(new Route()));
        RouteService service = new RouteService(repository);
        Assertions.assertDoesNotThrow(()->service.findById(2L));
    }


}