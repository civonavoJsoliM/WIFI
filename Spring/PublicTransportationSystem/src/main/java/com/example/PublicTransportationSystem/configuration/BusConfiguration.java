package com.example.PublicTransportationSystem.configuration;

import com.example.PublicTransportationSystem.data.Bus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BusConfiguration {

    @Bean
    List<Bus> buses() {
        return new ArrayList<>();
    }
}
