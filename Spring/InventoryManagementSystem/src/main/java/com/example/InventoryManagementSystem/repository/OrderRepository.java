package com.example.InventoryManagementSystem.repository;

import com.example.InventoryManagementSystem.data.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    private final List<Order> orders;

    public OrderRepository(List<Order> orders) {
        this.orders = orders;
    }

    public Order add(Order order) {
        orders.add(order);
        return order;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
