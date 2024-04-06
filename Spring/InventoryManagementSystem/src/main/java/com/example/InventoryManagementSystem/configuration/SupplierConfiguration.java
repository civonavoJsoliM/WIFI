package com.example.InventoryManagementSystem.configuration;

import com.example.InventoryManagementSystem.data.Supplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SupplierConfiguration {

    @Bean
    List<Supplier> suppliers() {
        return new ArrayList<>();
    }
}
