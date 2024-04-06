package view;

import java.util.List;

public class Printer<T> {
    public void printGreeting() {
        System.out.println("Welcome to Bookworms!\nWhat would you like to do: ");
    }
    public void printOptions() {
        System.out.println("\nA: Display all products");
        System.out.println("B: Display all orders");
        System.out.println("C: Make a new order");
        System.out.print("Your choice: ");
    }
    public void displayList(List<T> list, String className) {
        System.out.printf("\nThis is the list of %s: \n", className);
        for (T obj : list) {
            System.out.println(obj);
        }
    }
    public void printEnterCustomerId() {
        System.out.print("Enter the customer ID: ");
    }
    public void printEnterProduct() {
        System.out.print("Which product would you like to order: ");
    }
    public void printEnterAmount() {
        System.out.print("Amount: ");
    }
    public void printInvalidInput() {
        System.out.print("Please enter a valid input: ");
    }
}
