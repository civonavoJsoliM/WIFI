package com.example.FoodDeliverySystem.logic;


import com.example.FoodDeliverySystem.data.Customer;
import com.example.FoodDeliverySystem.data.Order;
import com.example.FoodDeliverySystem.data.Restaurant;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalTime;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantServiceTest {

    @ParameterizedTest
    @MethodSource
    void get_Restaurants_Which_Deliver_In_Certain_Area(List<Restaurant> restaurants, String area, List<Restaurant> expected) {
        RestaurantService restaurantService = new RestaurantService();
        List<Restaurant> restaurantsWhichDeliverInCertainArea = restaurantService.get_Restaurants_Which_Deliver_In_Certain_Area(restaurants, area);
        assertEquals(expected, restaurantsWhichDeliverInCertainArea);
    }

    static Stream<Arguments> get_Restaurants_Which_Deliver_In_Certain_Area() {
        return Stream.of(
                Arguments.of(getRestaurants(), "Vienna", List.of(getRestaurants().get(0), getRestaurants().get(1),
                        getRestaurants().get(2), getRestaurants().get(5))),
                Arguments.of(getRestaurants(), "", List.of()),
                Arguments.of(getRestaurants(), "Bratislava", List.of()),
                Arguments.of(List.of(), "Vienna", List.of()),
                Arguments.of(List.of(), "", List.of())
        );
    }

    @ParameterizedTest
    @MethodSource
    void get_Total_Revenue_From_Certain_Restaurant(List<Order> orders, String restaurant, double expected) {
        RestaurantService restaurantService = new RestaurantService();
        double revenue = restaurantService.get_Total_Revenue_From_Certain_Restaurant(orders, restaurant);
        assertEquals(expected, revenue);
    }

    static Stream<Arguments> get_Total_Revenue_From_Certain_Restaurant() {
        return Stream.of(
                Arguments.of(getOrders(), getRestaurants().get(0).name(), 220),
                Arguments.of(getOrders(), getRestaurants().get(5).name(), 120),
                Arguments.of(getOrders(), "", 0),
                Arguments.of(getOrders(), "KFC", 0),
                Arguments.of(getOrders(), getRestaurants().get(1).name(), 0),
                Arguments.of(List.of(), getRestaurants().get(2).name(), 0),
                Arguments.of(List.of(), "", 0),
                Arguments.of(List.of(), "Saloon", 0)
        );
    }

    @ParameterizedTest
    @MethodSource
    void get_Customer_With_Most_Orders(List<Order> orders, Optional<Map.Entry<Customer, Long>> expected) {
        RestaurantService restaurantService = new RestaurantService();
        Optional<Map.Entry<Customer, Long>> customerWithMostOrders = restaurantService.get_Customer_With_Most_Orders(orders);
        assertEquals(expected, customerWithMostOrders);
    }

    static Stream<Arguments> get_Customer_With_Most_Orders() {
        return Stream.of(
                Arguments.of(getOrders(), Optional.of(new AbstractMap.SimpleEntry<>(getCustomers().get(0), 3L))),
                Arguments.of(List.of(), Optional.empty())
        );
    }

    static List<Order> getOrders() {
        return List.of(
                new Order("1", getRestaurants().get(0), getCustomers().get(0), "Vienna", 50, LocalTime.now()),
                new Order("2", getRestaurants().get(0), getCustomers().get(1), "Bregenz", 70, LocalTime.now()),
                new Order("3", getRestaurants().get(0), getCustomers().get(3), "St.Pölten", 100, LocalTime.now()),
                //new Order("4", getRestaurants().get(1), getCustomers().get(0), "Vienna", 30, LocalTime.now()),
                new Order("5", getRestaurants().get(2), getCustomers().get(0), "Vienna", 25, LocalTime.now()),
                new Order("6", getRestaurants().get(2), getCustomers().get(3), "St.Pölten", 50, LocalTime.now()),
                new Order("7", getRestaurants().get(3), getCustomers().get(2), "Milano", 60, LocalTime.now()),
                new Order("8", getRestaurants().get(4), getCustomers().get(4), "Sarajevo", 250, LocalTime.now()),
                new Order("9", getRestaurants().get(5), getCustomers().get(0), "Vienna", 80, LocalTime.now()),
                new Order("10", getRestaurants().get(5), getCustomers().get(1), "Vienna", 40, LocalTime.now())
        );
    }
    static List<Restaurant> getRestaurants() {
        return List.of(
                new Restaurant("1", "Walter", "Serbian", "Vienna"),
                new Restaurant("2", "McDonald's", "American", "Vienna"),
                new Restaurant("3", "Burger King", "American", "Vienna"),
                new Restaurant("4", "Vapiano", "Italian", "Milano"),
                new Restaurant("5", "Subway", "American", "Linz"),
                new Restaurant("6", "Galaxie", "Serbian", "Vienna")
        );
    }
    static List<Customer> getCustomers() {
        return List.of(
                new Customer("1", "Max", "Vienna", "12345"),
                new Customer("2", "Patrick", "Bregenz", "23456"),
                new Customer("3", "Sebastian", "Milano", "34567"),
                new Customer("4", "Hans", "St.Pölten", "45678"),
                new Customer("5", "Franz", "Sarajevo", "56789")
        );
    }
}