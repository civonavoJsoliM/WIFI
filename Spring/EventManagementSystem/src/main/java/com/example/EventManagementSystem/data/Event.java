package com.example.EventManagementSystem.data;

import java.time.LocalDate;

public record Event(String id, String name, String location, LocalDate date) {
}
