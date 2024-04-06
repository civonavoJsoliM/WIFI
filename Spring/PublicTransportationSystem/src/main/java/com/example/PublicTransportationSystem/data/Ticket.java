package com.example.PublicTransportationSystem.data;

import java.time.LocalDate;

public record Ticket(String id, String passengerName, LocalDate purchaseDate, Route route, Bus bus) {
}
