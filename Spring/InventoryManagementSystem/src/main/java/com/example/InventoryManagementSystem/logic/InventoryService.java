package com.example.InventoryManagementSystem.logic;

import com.example.InventoryManagementSystem.data.Item;
import com.example.InventoryManagementSystem.data.Order;
import com.example.InventoryManagementSystem.data.Supplier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    public List<Item> getItemsCheaperThanCertainPrice(List<Item> items, double price) {
        return items.stream()
                .filter(item -> item.price() <= price)
                .toList();
    }

    public Optional<Map.Entry<Supplier, Long>> getSupplierWIthMostOrders(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::supplier, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }

    public double getTotalCostForSpecificPeriod(List<Order> orders, LocalDate start, LocalDate end) {
        return orders.stream()
                .filter(order -> isDateEqualsOrAfterStart(order, start) && isDateEqualsOrBeforeEnd(order, end))
                .mapToDouble(order -> order.item().price() * order.quantity())
                .sum();
    }
    private boolean isDateEqualsOrAfterStart(Order order, LocalDate start) {
        return order.orderDate().isAfter(start) || order.orderDate().isEqual(start);
    }
    private boolean isDateEqualsOrBeforeEnd(Order order, LocalDate end) {
        return order.orderDate().isBefore(end) || order.orderDate().isEqual(end);
    }

}
