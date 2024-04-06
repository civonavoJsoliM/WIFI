package data;

import java.time.LocalDate;

public record Order(int id, LocalDate date, double totalAmount) {
}
