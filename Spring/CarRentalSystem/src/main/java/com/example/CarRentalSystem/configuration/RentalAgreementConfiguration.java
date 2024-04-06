package com.example.CarRentalSystem.configuration;

import com.example.CarRentalSystem.data.RentalAgreement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RentalAgreementConfiguration {

    @Bean
    List<RentalAgreement> rentalAgreementList() {
        return new ArrayList<>();
    }
}
