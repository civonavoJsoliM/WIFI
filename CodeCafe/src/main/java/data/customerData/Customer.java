package data.customerData;

public record Customer(int customerId, String firstName, String lastName, String e_mail, String phoneNumber) {
    @Override
    public String toString() {
        return "Customer ID: " + customerId +
                " | " + "first name: " + firstName + " | " +
                "last name: " + lastName + " | " +
                "E-Mail: " + e_mail + " | " +
                "phone number: " + phoneNumber;
    }
}
