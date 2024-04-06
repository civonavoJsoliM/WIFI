package com.example.CarRentalSystem.logic;

import com.example.CarRentalSystem.data.Customer;
import com.example.CarRentalSystem.data.RentalAgreement;
import com.example.CarRentalSystem.data.Vehicle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RentalServiceTest {
    @ParameterizedTest
    @MethodSource
    void getMostLoyalCustomer(List<RentalAgreement> rentalAgreements, Optional<Map.Entry<Customer, Long>> expected) {
        RentalService rentalService = new RentalService();
        Optional<Map.Entry<Customer, Long>> customer = rentalService.getMostLoyalCustomer(rentalAgreements);
        assertEquals(expected, customer);
    }

    static Stream<Arguments> getMostLoyalCustomer() {
        return Stream.of(
                Arguments.of(List.of(), Optional.empty()),
                Arguments.of((getRentalAgreements(getVehicles(), getCustomers())),
                        Optional.of(new AbstractMap.SimpleEntry<Customer, Long>(getCustomers().get(0), 3L) {
                        }))
        );
    }

    @ParameterizedTest
    @MethodSource
    void getTotalIncomeFromGivenPeriod(List<RentalAgreement> rentalAgreements, LocalDate start, LocalDate end, double expected) {
        RentalService rentalService = new RentalService();
        double totalIncome = rentalService.getTotalIncomeFromGivenPeriod(rentalAgreements, start, end);
        assertEquals(expected, totalIncome);
    }

    static Stream<Arguments> getTotalIncomeFromGivenPeriod() {
        return Stream.of(
                Arguments.of(List.of(), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 1), 0.0),
                Arguments.of(getRentalAgreements(getVehicles(), getCustomers()),
                        LocalDate.of(2024, 2, 16), LocalDate.of(2024, 2, 20), 1599.96),
                Arguments.of(getRentalAgreements(getVehicles(), getCustomers()),
                        LocalDate.of(2024, 2, 1), LocalDate.of(2024, 2, 5), 1759.96),
                Arguments.of(getRentalAgreements(getVehicles(), getCustomers()),
                        LocalDate.of(2023, 12, 30), LocalDate.of(2024, 1, 10), 629.91),
                Arguments.of(getRentalAgreements(getVehicles(), getCustomers()),
                        LocalDate.of(2024, 3, 1), LocalDate.of(2024, 5, 1), 1609.77),
                Arguments.of(getRentalAgreements(getVehicles(), getCustomers()),
                        LocalDate.of(2024, 3, 29), LocalDate.of(2024, 5, 5), 6 * getVehicles().get(0).price())
        );
    }
    
    @ParameterizedTest
    @MethodSource
    void getAvailableVehiclesInPriceRange(List<Vehicle> vehicles, List<RentalAgreement> rentalAgreements, double price, List<Vehicle> expected) {
        RentalService rentalService = new RentalService();
        List<Vehicle> availableVehicles = rentalService.getAvailableVehiclesInPriceRange(vehicles, rentalAgreements, price);
        assertEquals(expected, availableVehicles);
    }

    static Stream<Arguments> getAvailableVehiclesInPriceRange() {
        return Stream.of(
                Arguments.of(getVehicles(), getRentalAgreements(getVehicles(), getCustomers()), 80.0,
                        List.of(getVehicles().get(2), getVehicles().get(3), getVehicles().get(4))),
                Arguments.of(List.of(), List.of(), 0.0, List.of()),
                Arguments.of(List.of(), List.of(), 100.0, List.of()),
                Arguments.of(getVehicles(), getRentalAgreements(getVehicles(), getCustomers()), 0.0, getVehicles()),
                Arguments.of(getVehicles(), getRentalAgreements(getVehicles(), getCustomers()), 210.0, List.of(getVehicles().get(4)))
        );
    }


    private static List<RentalAgreement> getRentalAgreements(List<Vehicle> vehicles, List<Customer> customers) {
        return List.of(new RentalAgreement("5", LocalDate.of(2024, 2, 15), LocalDate.of(2024, 2, 28), vehicles.get(4), customers.get(4)),
                new RentalAgreement("6", LocalDate.now(), LocalDate.of(2024, 4, 4), vehicles.get(0), customers.get(0)),
                new RentalAgreement("7", LocalDate.of(2024, 2, 2), LocalDate.of(2024, 2, 8), vehicles.get(3), customers.get(0)),
                new RentalAgreement("4", LocalDate.of(2024, 1, 28), LocalDate.of(2024, 2, 7), vehicles.get(3), customers.get(3)),
                new RentalAgreement("3", LocalDate.of(2024, 2, 1), LocalDate.of(2024, 2, 15), vehicles.get(2), customers.get(2)),
                new RentalAgreement("1", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 1), vehicles.get(0), customers.get(0)));
    }

    private static List<Vehicle> getVehicles() {
        return List.of(new Vehicle("1", LocalDate.now(), "Mercedes", 69.99),
                new Vehicle("2", LocalDate.now(), "Audi", 49.99),
                new Vehicle("3", LocalDate.now(), "BMW", 89.99),
                new Vehicle("4", LocalDate.now(), "Ferrari", 200),
                new Vehicle("5", LocalDate.now(), "Range Rover", 399.99));
    }

    private static List<Customer> getCustomers() {
        return List.of(new Customer("1", "Max", "12345"),
                new Customer("2", "Phillip", "12345"),
                new Customer("3", "Franz", "12345"),
                new Customer("4", "Peter", "12345"),
                new Customer("5", "Karl-Heins", "12345"));
    }
}