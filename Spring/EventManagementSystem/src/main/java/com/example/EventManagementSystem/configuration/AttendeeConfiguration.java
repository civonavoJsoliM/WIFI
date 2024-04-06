package com.example.EventManagementSystem.configuration;

import com.example.EventManagementSystem.data.Attendee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AttendeeConfiguration {

    @Bean
    List<Attendee> attendees() {
        return new ArrayList<>();
    }
}
