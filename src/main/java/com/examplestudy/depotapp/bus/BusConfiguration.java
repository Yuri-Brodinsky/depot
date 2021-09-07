package com.examplestudy.depotapp.bus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BusConfiguration {
    @Bean
    public CommandLineRunner commandLineRunner(BusRepository repository){
        return args -> {
            repository.saveAll(List.of(
                    new Bus("AD-45-I","VAZ-53",32,20,3,
                            LocalDate.of(2002, Month.APRIL,15)),
                    new Bus("AD-47-V","VAZ-54",32,18,3,
                            LocalDate.of(2005, Month.MARCH,16))

            ));
        };
    }
}
