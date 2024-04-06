package data.customerData;

public record Customer(int customerId, String firstName, String lastName, String eMail, String address, String phoneNumber) {
    @Override
    public String toString() {
        return "Customer ID: " + customerId + " | " +
                "First name: " + firstName + " | " +
                "Last name: " + lastName + " | " +
                "E-Mail: " + eMail + " | " +
                "Address: " + address + " | " +
                "Phone number: " + phoneNumber + " | ";
    }
}
