package com.example.InventoryManagementSystem.data;

import java.time.LocalDate;

public record Order(String id, Item item, int quantity, LocalDate orderDate, Supplier supplier) {
}
