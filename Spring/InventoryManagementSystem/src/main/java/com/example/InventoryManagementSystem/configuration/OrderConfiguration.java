package com.example.InventoryManagementSystem.configuration;

import com.example.InventoryManagementSystem.data.Order;
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
