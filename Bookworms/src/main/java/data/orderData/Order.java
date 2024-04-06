package data.orderData;

import java.time.LocalDate;

public record Order(int orderId,LocalDate orderDate, String firstName, String lastName, int amount, String title, double price) {
    @Override
    public String toString() {
        return "Order ID: " + orderId + " | " +
                "Order Date: " + orderDate + " | " +
                "First name: " + firstName + " | " +
                "Last name: " + lastName + " | " +
                "Amount: " + amount + " | " +
                "Title: " + title + " | " +
                "Price: " + price + "€";
    }
}
