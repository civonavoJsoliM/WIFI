package data;

import java.util.List;

public record Customer(String name, String address, String e_mail, List<Order> orders) {
}
