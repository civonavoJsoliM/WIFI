package com.example.FoodDeliverySystem.repository;

import com.example.FoodDeliverySystem.data.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepository {

    private final List<Restaurant> restaurants;

    public RestaurantRepository(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public Restaurant add(Restaurant restaurant) {
        restaurants.add(restaurant);
        return restaurant;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
