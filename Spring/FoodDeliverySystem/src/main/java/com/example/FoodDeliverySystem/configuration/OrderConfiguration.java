package com.example.FoodDeliverySystem.configuration;

import com.example.FoodDeliverySystem.data.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OrderConfiguration {

    @Bean
    List<Order> orders() {
        return new ArrayList<>();
    }
}
