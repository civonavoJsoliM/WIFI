package logic;

import data.Customer;
import data.Order;
import data.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ShopService {
    public List<Product> getProductCheaperThen(List<Product> products, double amount) {
        return products.stream()
                .filter(product -> product.price() < amount)
                .collect(Collectors.toList());
    }

    public Double calculateRevenue(List<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.orders().stream())
                .mapToDouble(Order::totalAmount)
                .sum();
    }
}
