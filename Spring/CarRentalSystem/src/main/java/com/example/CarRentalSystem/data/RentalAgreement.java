package com.example.CarRentalSystem.data;

import java.time.LocalDate;

public record RentalAgreement(String id, LocalDate start, LocalDate end, Vehicle vehicle, Customer customer) {
}
