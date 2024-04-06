package com.example.PublicTransportationSystem.data;

import java.time.LocalTime;

public record Route(String id, String startPoint, String endPoint, LocalTime duration) {
}
