package com.example.FoodDeliverySystem.configuration;

import com.example.FoodDeliverySystem.data.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CustomerConfiguration {

    @Bean
    List<Customer> customers() {
        return new ArrayList<>();
    }
}
