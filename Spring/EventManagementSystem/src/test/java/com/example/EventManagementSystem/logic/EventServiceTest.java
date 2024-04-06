package com.example.EventManagementSystem.logic;

import com.example.EventManagementSystem.data.Attendee;
import com.example.EventManagementSystem.data.Event;
import com.example.EventManagementSystem.data.Ticket;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EventServiceTest {

    @ParameterizedTest
    @MethodSource
    void getEventsInCertainLocation(List<Event> events, String location, List<Event> expected) {
        EventService eventService = new EventService();
        List<Event> eventsInCertainLocation = eventService.getEventsInCertainLocation(events, location);
        assertEquals(expected, eventsInCertainLocation);
    }

    static Stream<Arguments> getEventsInCertainLocation() {
        return Stream.of(
                Arguments.of(getEvents(), "Wien", List.of(getEvents().get(1), getEvents().get(2), getEvents().get(4))),
                Arguments.of(List.of(), "Wien", List.of()),
                Arguments.of(List.of(), "", List.of()),
                Arguments.of(getEvents(), "", List.of()),
                Arguments.of(getEvents(), "Salzburg", List.of())
        );
    }

    @ParameterizedTest
    @MethodSource
    void getTotalRevenueFromCertainEvent(List<Attendee> attendees, String event, double expected) {
        EventService eventService = new EventService();
        double revenue = eventService.getTotalRevenueFromCertainEvent(attendees, event);
        assertEquals(expected, revenue);
    }

    static Stream<Arguments> getTotalRevenueFromCertainEvent() {
        return Stream.of(
          Arguments.of(getAttendees(), getEvents().get(2).name(), 50),
          Arguments.of(getAttendees(), getEvents().get(1).name(), 120),
          Arguments.of(getAttendees(), "", 0.0),
          Arguments.of(getAttendees(), "Basketballspiel", 0.0),
          Arguments.of(List.of(), getEvents().get(2).name(), 0.0),
          Arguments.of(List.of(), "", 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource
    void getEventWithMostAttendees(List<Attendee> attendees, Optional<Map.Entry<Event, Long>> expected) {
        EventService eventService = new EventService();
        Optional<Map.Entry<Event, Long>> eventWithMostAttendees = eventService.getEventWithMostAttendees(attendees);
        assertEquals(expected, eventWithMostAttendees);
    }

    static Stream<Arguments> getEventWithMostAttendees() {
        return Stream.of(
                Arguments.of(getAttendees(), Optional.of(new AbstractMap.SimpleEntry<>(getEvents().get(4), 5L))),
                Arguments.of(List.of(), Optional.empty())
        );
    }


    private static List<Attendee> getAttendees() {
        return List.of(
                new Attendee("1", "Max", "max@gmail.com", getTickets().get(0)),
                new Attendee("2", "Franz", "franz@gmail.com", getTickets().get(0)),
                new Attendee("3", "Hans", "hans@gmail.com", getTickets().get(1)),
                new Attendee("4", "Peter", "peter@gmail.com", getTickets().get(1)),
                new Attendee("5", "Sebastian", "sebastian@gmail.com", getTickets().get(1)),
                new Attendee("6","Phillip", "phillip@gmail.com", getTickets().get(1)),
                new Attendee("7", "Markus", "markus@gmail.com", getTickets().get(2)),
                new Attendee("8", "Joseph", "joseph@gmail.com", getTickets().get(4)),
                new Attendee("9", "Marks", "marks@gmail.com", getTickets().get(4)),
                new Attendee("10", "Andreas", "adnreas@gmai.com", getTickets().get(4)),
                new Attendee("11", "Florian", "florian@gmail.com", getTickets().get(4)),
                new Attendee("12", "Michael", "michael@gmail.com", getTickets().get(4)));
    }

    private static List<Ticket> getTickets() {
        return List.of(
                new Ticket("1", getEvents().get(0), "Normal", 15),
                new Ticket("2", getEvents().get(1), "Normal", 30),
                new Ticket("3", getEvents().get(2), "Normal", 50),
                new Ticket("4", getEvents().get(3), "Normal", 10),
                new Ticket("5", getEvents().get(4), "Normal", 20));
    }

    private static List<Event> getEvents() {
        return List.of(
                new Event("1", "EXIT", "Novi Sad", LocalDate.now()),
                new Event("2", "Messe", "Wien", LocalDate.now()),
                new Event("3", "F1 Messe", "Wien", LocalDate.now()),
                new Event("4", "Sajam", "Novi Sad", LocalDate.now()),
                new Event("5", "Fussballspiel", "Wien", LocalDate.now()));
    }
}