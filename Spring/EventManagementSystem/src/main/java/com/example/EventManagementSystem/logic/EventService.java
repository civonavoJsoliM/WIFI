package com.example.EventManagementSystem.logic;

import com.example.EventManagementSystem.data.Attendee;
import com.example.EventManagementSystem.data.Event;
import com.example.EventManagementSystem.data.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    public List<Event> getEventsInCertainLocation(List<Event> events, String location) {
        return events.stream()
                .filter(event -> event.location().equals(location))
                .toList();
    }

    public double getTotalRevenueFromCertainEvent(List<Attendee> attendees, String event) {
        return attendees.stream()
                .map(Attendee::ticket)
                .filter(ticket -> ticket.event().name().equals(event))
                .mapToDouble(Ticket::price)
                .sum();
    }

    public Optional<Map.Entry<Event, Long>> getEventWithMostAttendees(List<Attendee> attendees) {
        return attendees.stream()
                .collect(Collectors.groupingBy(attendee -> attendee.ticket().event(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }
}
