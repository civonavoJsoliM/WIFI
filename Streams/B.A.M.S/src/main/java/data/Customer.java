package data;

import java.util.List;

public record Customer(String name, String address, int phoneNumber, List<Account> accounts) {
}
