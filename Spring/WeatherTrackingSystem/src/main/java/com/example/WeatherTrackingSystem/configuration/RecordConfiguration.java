package com.example.WeatherTrackingSystem.configuration;

import com.example.WeatherTrackingSystem.data.Record;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RecordConfiguration {

    @Bean
    List<Record> records() {
        return new ArrayList<>();
    }
}
