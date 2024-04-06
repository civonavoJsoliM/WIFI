package com.example.CarRentalSystem.configuration;

import com.example.CarRentalSystem.data.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class VehicleConfiguration {
    @Bean
    List<Vehicle> vehicles() {
        return new ArrayList<>();
    }
}
