package com.examplestudy.depotapp.Route;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;

@Configuration
public class RouteConfiguration {
    @Bean
    public CommandLineRunner commandLineRunner3(RouteRepository repository){
        return args -> {
            repository.saveAll(List.of(
                new Route("Baranovichi","Minsk",130,120),
                new Route("Minsk","Baranovichi",130,120),
                    new Route("Baranovichi","Brest",200,160),
                    new Route("Brest","Baranovichi",200,160)
            ));
        };
    }
}