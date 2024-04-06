package com.example.FoodDeliverySystem.data;

import java.time.LocalTime;

public record Order(String id, Restaurant restaurant, Customer customer, String deliveryAddress, double totalPrice,
                    LocalTime deliveryTime) {
}
