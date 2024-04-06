package com.example.PublicTransportationSystem.configuration;

import com.example.PublicTransportationSystem.data.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RouteConfiguration {

    @Bean
    List<Route> routes() {
        return new ArrayList<>();
    }
}
