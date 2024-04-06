package com.example.PublicTransportationSystem.configuration;

import com.example.PublicTransportationSystem.data.Ticket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TicketConfiguration {

    @Bean
    List<Ticket> tickets() {
        return new ArrayList<>();
    }
}
