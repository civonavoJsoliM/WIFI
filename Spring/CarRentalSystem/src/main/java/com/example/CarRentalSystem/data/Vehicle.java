package com.example.CarRentalSystem.data;

import java.time.LocalDate;

public record Vehicle(String id, LocalDate make, String model, double price) {
}
