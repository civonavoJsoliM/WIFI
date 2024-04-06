package com.example.PublicTransportationSystem.repository;

import com.example.PublicTransportationSystem.data.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepository {

    private final List<Ticket> tickets;

    public TicketRepository(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Ticket add(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
