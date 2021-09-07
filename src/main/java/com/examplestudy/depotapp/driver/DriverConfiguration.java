package com.examplestudy.depotapp.driver;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class DriverConfiguration {
    @Bean
    public CommandLineRunner commandLineRunner2(DriverRepository repository){
        return args -> {
            repository.saveAll(List.of(
                   new Driver("Ivan","Ivanov",
                           LocalDate.of(1993,Month.SEPTEMBER, 15),
                           LocalDate.of(2015, Month.JULY, 18)),
                    new Driver("Petr","Petrov",
                            LocalDate.of(1995,Month.MAY, 3),
                            LocalDate.of(2017, Month.SEPTEMBER, 5))
            ));
        };
    }
}
