package com.example.EventManagementSystem.repository;

import com.example.EventManagementSystem.data.Event;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepository {

    private final List<Event> events;

    public EventRepository(List<Event> events) {
        this.events = events;
    }

    public Event add(Event event) {
        events.add(event);
        return event;
    }

    public List<Event> getEvents() {
        return events;
    }
}
