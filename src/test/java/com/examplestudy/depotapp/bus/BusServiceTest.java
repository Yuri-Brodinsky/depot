package com.examplestudy.depotapp.bus;


import com.examplestudy.depotapp.response.AlreadyExistException;


import com.examplestudy.depotapp.response.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;


import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)

class BusServiceTest {
    @Mock
    private BusRepository mockedRepository;
    private static Bus bus;

    @BeforeAll
    public static void init(){
        bus = new Bus("AB-221","VAZ-2",
                34,3,3,
                LocalDate.of(2003, Month.APRIL,12));
    }
    @Test
    public void shouldCallSave(){
        when(mockedRepository.findByNumber("AB-221")).thenReturn(Optional.empty());
        BusService service = new BusService(mockedRepository);
        service.add(bus);
        verify(mockedRepository,times(1)).save(bus);
    }
    @Test
    public void shouldThrowNotFoundException() {
        when(mockedRepository.findById(138L)).thenReturn(Optional.empty());
        BusService service = new BusService(mockedRepository);
        Throwable thrown = Assertions.assertThrows(NotFoundException.class,
                () -> service.findById(138L));
        Assertions.assertEquals("no such bus found", thrown.getMessage());
    }
    @Test
    public void shouldThrowAlreadyExistException(){
        when(mockedRepository.findByNumber("AB-221")).thenReturn(Optional.of(bus));
        BusService service = new BusService(mockedRepository);
        Throwable thrown = Assertions.assertThrows(AlreadyExistException.class,
                ()->service.add(bus));
        Assertions.assertEquals("bus with same number is already exist",thrown.getMessage());
    }
    @Test
    public void shouldNotThrowNotFoundException() {
        when(mockedRepository.findById(2L)).thenReturn(Optional.of(bus));
        BusService service = new BusService(mockedRepository);
        Assertions.assertDoesNotThrow(()->service.findById(2L));
    }
    @Test
    public void shouldNotThrowAlreadyExistException(){
        when(mockedRepository.findByNumber("AB-221")).thenReturn(Optional.empty());
        BusService service = new BusService(mockedRepository);
        Assertions.assertDoesNotThrow(()->service.add(bus));
    }
}