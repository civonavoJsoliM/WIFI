package com.example.EventManagementSystem.configuration;

import com.example.EventManagementSystem.data.Ticket;
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
