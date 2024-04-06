package logic;

import data.Guest;
import data.Reservation;
import data.Room;
import data.RoomType;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HotelService {
    public List<Room> getFreeRoomsDuringCertainPeriod(List<Room> rooms, List<Reservation> reservations, RoomType roomType, LocalDate checkIn, LocalDate checkOut) {
        return  rooms.stream()
                .filter(room -> !reservations.stream()
                        .filter(reservation -> reservation.checkIn().isAfter(checkOut) && reservation.checkOut().isBefore(checkIn))
                        .map(Reservation::room)
                        .toList()
                        .contains(room))
                .collect(Collectors.toList());
    }

    public Optional<Guest> guestWithMostBookings(List<Reservation> reservations) {
        return reservations.stream()
                .collect(Collectors.groupingBy(Reservation::guest, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey);
    }

    //NICHT FERIG!
    public Double getOccupancyOfDuringCertainPeriod(List<Reservation> reservations, LocalDate begin, LocalDate end) {
        return reservations.stream()
                .filter(reservation -> reservation.checkIn().isBefore(end) && reservation.checkOut().isAfter(begin))
                .collect(Collectors.averagingDouble())

    }
}
