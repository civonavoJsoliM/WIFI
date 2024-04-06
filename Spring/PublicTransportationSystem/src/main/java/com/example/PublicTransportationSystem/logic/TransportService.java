package com.example.PublicTransportationSystem.logic;

import com.example.PublicTransportationSystem.data.Bus;
import com.example.PublicTransportationSystem.data.Route;
import com.example.PublicTransportationSystem.data.Ticket;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

@Service
public class TransportService {

    public List<Route> getRoutesFromCertainPoints(List<Route> routes, String start, String end) {
        return routes.stream()
                .filter(route -> route.startPoint().equals(start) && route.endPoint().equals(end))
                .toList();
    }

    public Map<Route, Long> getTotalAmountOfSoldTicketsForCertainRoute(List<Ticket> tickets, String start, String end) {
        return tickets.stream()
                .filter(ticket -> ticket.route().startPoint().equals(start) && ticket.route().endPoint().equals(end))
                .collect(Collectors.groupingBy((Ticket::route), Collectors.counting()));
    }

    public Optional<Map.Entry<Bus, Integer>> getBusWithMostKMTraveled(List<Ticket> tickets) {
        return tickets.stream()
                .collect(Collectors.groupingBy(Ticket::bus, Collectors.summingInt(getDurationTime())))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }

    private ToIntFunction<Ticket> getDurationTime() {
        return ticket -> ((ticket.route().duration().getHour() * 60) + ticket.route().duration().getMinute()) / 60;
    }
}
