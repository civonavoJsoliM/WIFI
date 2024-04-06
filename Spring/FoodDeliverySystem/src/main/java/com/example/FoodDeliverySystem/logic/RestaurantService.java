package com.example.FoodDeliverySystem.logic;

import com.example.FoodDeliverySystem.data.Customer;
import com.example.FoodDeliverySystem.data.Order;
import com.example.FoodDeliverySystem.data.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    public List<Restaurant> get_Restaurants_Which_Deliver_In_Certain_Area(List<Restaurant> restaurants, String area) {
        return restaurants.stream()
                .filter(restaurant -> restaurant.deliveryArea().equals(area))
                .toList();
    }

    public double get_Total_Revenue_From_Certain_Restaurant(List<Order> orders, String restaurant) {
        return orders.stream()
                .filter(order -> order.restaurant().name().equals(restaurant))
                .mapToDouble(Order::totalPrice)
                .sum();
    }

    public Optional<Map.Entry<Customer, Long>> get_Customer_With_Most_Orders(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(order -> order.customer(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }

}
