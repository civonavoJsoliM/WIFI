package com.example.PublicTransportationSystem.repository;

import com.example.PublicTransportationSystem.data.Bus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BusRepository {

    private final List<Bus> buses;

    public BusRepository(List<Bus> buses) {
        this.buses = buses;
    }

    public Bus add(Bus bus) {
        buses.add(bus);
        return bus;
    }

    public List<Bus> getBuses() {
        return buses;
    }
}
