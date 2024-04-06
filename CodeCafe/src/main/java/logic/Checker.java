package logic;

import data.customerData.Customer;
import data.customerData.CustomerColumns;

import java.util.List;
import java.util.regex.Pattern;

public class Checker {
    public boolean checkChoice(String input) {
        Pattern pattern = Pattern.compile("^[abcdABCD]$");
        return pattern.matcher(input).find();
    }
    public boolean checkIfNumber(String number) {
        Pattern pattern = Pattern.compile("^\\d+$");
        return pattern.matcher(number).find();
    }
    public boolean checkIfInputNotEmpty(String input) {
        Pattern pattern = Pattern.compile("\\w+");
        return pattern.matcher(input).find();
    }
    public boolean checkIfUserWantToInputPhoneNumber(String input) {
        Pattern pattern = Pattern.compile("^[yY]$");
        return pattern.matcher(input).find();
    }
    public boolean checkIfIDValid(List<Customer> customers, int customerId) {
        return customers.stream().anyMatch(customer -> customer.customerId() == customerId);
    }
    public boolean checkIfColumnValid(String input) {
        return input.equalsIgnoreCase(CustomerColumns.firstName.name()) || input.equalsIgnoreCase(CustomerColumns.lastName.name()) ||
                input.equalsIgnoreCase(CustomerColumns.eMail.name()) || input.equalsIgnoreCase(CustomerColumns.phoneNumber.name());
    }
}
