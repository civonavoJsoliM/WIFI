package com.example.CarRentalSystem.repository;

import com.example.CarRentalSystem.data.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleRepository {
    private final List<Vehicle> vehicles;

    public VehicleRepository(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    public Vehicle add(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
