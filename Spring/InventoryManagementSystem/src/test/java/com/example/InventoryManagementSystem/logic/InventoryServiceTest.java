package com.example.InventoryManagementSystem.logic;

import com.example.InventoryManagementSystem.data.Item;
import com.example.InventoryManagementSystem.data.Order;
import com.example.InventoryManagementSystem.data.Supplier;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {

    @ParameterizedTest
    @MethodSource
    void getItemsCheaperThanCertainPrice(List<Item> items, double price, List<Item> expected) {
        InventoryService inventoryService = new InventoryService();
        List<Item> itemsCheaperThan = inventoryService.getItemsCheaperThanCertainPrice(items, price);
        assertEquals(expected, itemsCheaperThan);
    }

    static Stream<Arguments> getItemsCheaperThanCertainPrice() {
        return Stream.of(
                Arguments.of(getItems(), 5.0, List.of(getItems().get(0), getItems().get(1), getItems().get(4), getItems().get(5), getItems().get(6))),
                Arguments.of(getItems(), 2, List.of(getItems().get(1), getItems().get(6))),
                Arguments.of(getItems(), 1000, getItems()),
                Arguments.of(List.of(), 100, List.of()),
                Arguments.of(List.of(), 0, List.of()),
                Arguments.of(getItems(), 0.0, List.of())
        );
    }

    @ParameterizedTest
    @MethodSource
    void getSupplierWIthMostOrders(List<Order> orders, Optional<Map.Entry<Supplier, Long>> expected) {
        InventoryService inventoryService = new InventoryService();
        Optional<Map.Entry<Supplier, Long>> supplierWithMostOrders = inventoryService.getSupplierWIthMostOrders(orders);
        assertEquals(expected, supplierWithMostOrders);
    }

    static Stream<Arguments> getSupplierWIthMostOrders() {
        return Stream.of(
                //Arguments.of(getOrders(), Optional.of(new AbstractMap.SimpleEntry<>(getSuppliers().get(1), 4L))),
                Arguments.of(List.of(), Optional.empty()),
                Arguments.of(getOrders(), Optional.of(new AbstractMap.SimpleEntry<>(getSuppliers().get(4), 3L)))
        );
    }

    @ParameterizedTest
    @MethodSource
    void getTotalCostForSpecificPeriod(List<Order> orders, LocalDate start, LocalDate end, double expected) {
        InventoryService inventoryService = new InventoryService();
        double totalCost = inventoryService.getTotalCostForSpecificPeriod(orders, start, end);
        assertEquals(expected, totalCost);
    }

    static Stream<Arguments> getTotalCostForSpecificPeriod() {
        return Stream.of(
                Arguments.of(getOrders(), LocalDate.of(2024, 2, 1), LocalDate.of(2024, 3, 1), 1134.31),
                Arguments.of(getOrders(), LocalDate.of(2024, 1, 15), LocalDate.of(2024, 2, 15), 4131),
                Arguments.of(getOrders(), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 10), 1562.22)
        );
    }

    static List<Order> getOrders() {
        return List.of(
                //new Order("1", getItems().get(5), 10, LocalDate.now(), getSuppliers().get(1)),
                new Order("2", getItems().get(2), 3, LocalDate.of(2024, 1, 1), getSuppliers().get(4)),
                new Order("3", getItems().get(3), 19, LocalDate.of(2024, 2, 1), getSuppliers().get(2)),
                //new Order("4", getItems().get(6), 100, LocalDate.now(), getSuppliers().get(1)),
                new Order("4", getItems().get(6), 100, LocalDate.of(2024, 1, 15), getSuppliers().get(4)),
                new Order("5", getItems().get(1), 35, LocalDate.of(2024, 2, 15), getSuppliers().get(3)),
                new Order("6", getItems().get(0), 25, LocalDate.of(2024, 1, 8), getSuppliers().get(2)),
                new Order("7", getItems().get(7), 15, LocalDate.of(2024, 2, 8), getSuppliers().get(1)),
                new Order("8", getItems().get(4), 200, LocalDate.of(2024, 1, 25), getSuppliers().get(4)),
                new Order("9", getItems().get(3), 30, LocalDate.of(2024, 1, 20), getSuppliers().get(3)),
                new Order("10", getItems().get(2), 1, LocalDate.of(2024, 1, 29), getSuppliers().get(1))
        );
    }

    static List<Supplier> getSuppliers() {
        return List.of(
                new Supplier("1", "DHL", "Max"),
                new Supplier("2", "POST", "Jospeh"),
                new Supplier("3", "DPD", "Patrick"),
                new Supplier("4", "TNT", "Moritz"),
                new Supplier("5", "AMAZON", "Sebastian")
        );
    }

    static List<Item> getItems() {
        return List.of(
                new Item("1", "Coca Cola", "Drinks", 2.49),
                new Item("2", "Apple", "Food", 0.99),
                new Item("3", "Laptop", "Electronics", 499.99),
                new Item("4", "T-Shirt", "Chlothes", 49.99),
                new Item("5", "Toothbrush", "Health", 3.99),
                new Item("6", "RedBull", "Drinks", 2.99),
                new Item("7", "Banana", "Food", 1.99),
                new Item("8", "Meat", "Food", 9.99)
        );
    }
}