package com.example.EventManagementSystem.configuration;

import com.example.EventManagementSystem.data.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class EventConfiguration {

    @Bean
    List<Event> events() {
        return new ArrayList<>();
    }
}
