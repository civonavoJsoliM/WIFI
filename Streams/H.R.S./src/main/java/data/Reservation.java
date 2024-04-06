package data;

import java.time.LocalDate;

public record Reservation(Room room, Guest guest, int id, LocalDate checkIn, LocalDate checkOut) {
}
