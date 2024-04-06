package com.example.FoodDeliverySystem.repository;

import com.example.FoodDeliverySystem.data.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    private final List<Customer> customers;

    public CustomerRepository(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer add(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
