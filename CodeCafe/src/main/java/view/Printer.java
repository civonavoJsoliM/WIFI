package view;

import data.customerData.Customer;

import java.util.List;

public class Printer {
    public  void printGreeting() {
        System.out.println("Welcome to ManageCustomers!\nWhat would you like to do: \n");
    }
    public void printOptions() {
        System.out.println("A: Display all customers");
        System.out.println("B: Add new customer");
        System.out.println("C: Delete customer");
        System.out.println("D: Update customer data");
        System.out.print("Enter A, B, C or D: ");
    }

    public void usersChoice() {
        System.out.print("Your choice: ");
    }

    public void printCustomers(List<Customer> customers) {
        System.out.println("\nThose are the customers: \n");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void printEnterPhoneNumber() {
        System.out.print("Enter the phone number: ");
    }
    public void printDataToBeUpdated() {
        System.out.print("Which data would you like to update?\nEnter 'firstName', 'lastName', 'eMail' or 'phoneNumber': ");
    }
    public void printToBeUpdatedInto() {
        System.out.print("To be updated into: ");
    }
    public void printEnterCustomerId() {
        System.out.print("For which customer? Please enter the customerId: ");
    }

    public void askIfToEnterPhoneNumber() {
        System.out.print("Would you like to enter a phone number? Enter 'Y' for yes or press any other button to continue without phone number: ");
    }

    public void customerAddedSuccessfully() {
        System.out.println("The customer has been added successfully!");
    }

    public void askWhichCustomerToDelete() {
        System.out.print("\nWhich customer would you like to delete? Please enter his/hers customer ID: ");
    }

    public void customerDeletedSuccessfully() {
        System.out.println("The customer has been deleted successfully!");
    }
    public void enterValidInput(){
        System.out.print("Please enter a valid input: ");
    }
    public void enterValidIdNumber() {
        System.out.print("Please enter a valid ID number: ");
    }
    public void printEnter(String input) {
        System.out.printf("Enter %s: ", input);
    }
}
