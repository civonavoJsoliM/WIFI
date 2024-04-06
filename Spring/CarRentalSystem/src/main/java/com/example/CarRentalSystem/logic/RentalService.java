package com.example.CarRentalSystem.logic;

import com.example.CarRentalSystem.data.Customer;
import com.example.CarRentalSystem.data.RentalAgreement;
import com.example.CarRentalSystem.data.Vehicle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentalService {

    public Optional<Map.Entry<Customer, Long>> getMostLoyalCustomer(List<RentalAgreement> rentalAgreements) {
        return rentalAgreements.stream()
                .collect(Collectors.groupingBy(RentalAgreement::customer, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }

    public double getTotalIncomeFromGivenPeriod(List<RentalAgreement> rentalAgreements, LocalDate start, LocalDate end) {
         return rentalAgreements.stream()
                .filter(rentalAgreement -> isStartInside(rentalAgreement, end) && isEndInside(rentalAgreement, start))
                .mapToDouble(rentalAgreement -> rentalAgreement.vehicle().price() *
                        Period.between(getStartDate(rentalAgreement, start), getEndDate(rentalAgreement, end)).getDays())
                .sum();
    }

    private boolean isStartInside(RentalAgreement rentalAgreement, LocalDate end) {
        return rentalAgreement.start().isBefore(end) || rentalAgreement.start().isEqual(end);
    }

    private boolean isEndInside(RentalAgreement rentalAgreement, LocalDate start) {
        return rentalAgreement.end().isAfter(start) || rentalAgreement.end().isEqual(start);
    }

    private LocalDate getStartDate(RentalAgreement rentalAgreement, LocalDate start) {
        return rentalAgreement.start().isAfter(start) || rentalAgreement.start().isEqual(start) ? rentalAgreement.start() : start;
    }

    private LocalDate getEndDate(RentalAgreement rentalAgreement, LocalDate end) {
        return rentalAgreement.end().isBefore(end) || rentalAgreement.end().isEqual(end) ? rentalAgreement.end() : end;
    }

    public List<Vehicle> getAvailableVehiclesInPriceRange(List<Vehicle> vehicles, List<RentalAgreement> rentalAgreements, double price) {
        return vehicles.stream()
                .filter(vehicle -> !rentedVehicles(rentalAgreements, vehicle))
                .filter(vehicle -> vehicle.price() >= price)
                .toList();
    }

    private boolean rentedVehicles(List<RentalAgreement> rentalAgreements, Vehicle vehicle) {
        return rentalAgreements.stream()
                .filter(rentalAgreement -> LocalDate.now().isBefore(rentalAgreement.end()) && LocalDate.now().isAfter(rentalAgreement.start()))
                .map(RentalAgreement::vehicle)
                .distinct().toList()
                .contains(vehicle);
    }

}
