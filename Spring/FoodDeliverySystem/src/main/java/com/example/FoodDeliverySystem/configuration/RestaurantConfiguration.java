package com.example.FoodDeliverySystem.configuration;

import com.example.FoodDeliverySystem.data.Restaurant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestaurantConfiguration {

    @Bean
    List<Restaurant> restaurants() {
        return new ArrayList<>();
    }
}
