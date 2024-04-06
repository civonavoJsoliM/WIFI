package com.example.InventoryManagementSystem.configuration;

import com.example.InventoryManagementSystem.data.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ItemConfiguration {

    @Bean
    List<Item> items() {
        return new ArrayList<>();
    }
}
