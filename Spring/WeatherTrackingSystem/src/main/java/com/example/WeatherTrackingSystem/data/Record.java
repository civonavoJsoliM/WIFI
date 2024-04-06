package com.example.WeatherTrackingSystem.data;

import java.time.LocalDate;

public record Record(String id, String location, LocalDate date, double temperature) {
}
