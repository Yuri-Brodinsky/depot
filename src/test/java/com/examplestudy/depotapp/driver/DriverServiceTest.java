package com.examplestudy.depotapp.driver;

import com.examplestudy.depotapp.response.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DriverServiceTest {
    @Mock
    private DriverRepository repository;

    @Test
    public void shouldThrowNotFoundException(){
        when(repository.findById(3L)).thenReturn(Optional.empty());
        DriverService service = new DriverService(repository);
        Throwable thrown = Assertions.assertThrows(NotFoundException.class,
                ()->service.findById(3L));
        Assertions.assertEquals("no such driver found",thrown.getMessage());
    }
    @Test
    public void shouldNotThrowException(){
        when(repository.findById(2L)).thenReturn(Optional.of(new Driver()));
        DriverService service = new DriverService(repository);
        Assertions.assertDoesNotThrow(()->service.findById(2L));
    }


}