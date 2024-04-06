package com.example.EventManagementSystem.repository;

import com.example.EventManagementSystem.data.Attendee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttendeeRepository {

    private final List<Attendee> attendees;

    public AttendeeRepository(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    public Attendee add(Attendee attendee) {
        attendees.add(attendee);
        return attendee;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }
}
