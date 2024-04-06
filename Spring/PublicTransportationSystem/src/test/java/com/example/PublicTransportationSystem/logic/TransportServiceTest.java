package com.example.PublicTransportationSystem.logic;



import com.example.PublicTransportationSystem.data.Bus;
import com.example.PublicTransportationSystem.data.Route;
import com.example.PublicTransportationSystem.data.Ticket;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TransportServiceTest {

    @ParameterizedTest
    @MethodSource
    void getRoutesFromCertainPoints(List<Route> routes, String start, String end, List<Route> expected) {
        TransportService transportService = new TransportService();
        List<Route> routesFromCertainPoints = transportService.getRoutesFromCertainPoints(routes, start, end);
        assertEquals(expected, routesFromCertainPoints);
    }

    static Stream<Arguments> getRoutesFromCertainPoints() {
        return Stream.of(
                Arguments.of(getRoutes(), "Vienna", "Belgrade", List.of(getRoutes().get(0), getRoutes().get(1), getRoutes().get(2), getRoutes().get(3))),
                Arguments.of(getRoutes(), "", "", List.of()),
                Arguments.of(getRoutes(), "Vienna",  "", List.of()),
                Arguments.of(getRoutes(), "", "Belgrade", List.of()),
                Arguments.of(List.of(), "Vienna", "Belgrade", List.of()),
                Arguments.of(List.of(), "Vienna", "", List.of()),
                Arguments.of(List.of(), "", "Belgrade", List.of()),
                Arguments.of(List.of(), "", "", List.of())
                );
    }

    @ParameterizedTest
    @MethodSource
    void getTotalAmountOfSoldTicketsForCertainRoute(List<Ticket> tickets, String start, String end, Map<Route, Long> expected) {
        TransportService transportService = new TransportService();
        Map<Route, Long> routeLongMap = transportService.getTotalAmountOfSoldTicketsForCertainRoute(tickets, start, end);
        assertEquals(expected, routeLongMap);
    }

    static Stream<Arguments> getTotalAmountOfSoldTicketsForCertainRoute() {
        return Stream.of(
                Arguments.of(getTickets(), "Vienna", "Prague", Map.of(getRoutes().get(10), 1L, getRoutes().get(11), 1L,
                        getRoutes().get(12), 1L, getRoutes().get(13), 2L)),
                Arguments.of(getTickets(), "Belgrade", "Vienna", Map.of()),
                Arguments.of(getTickets(), "Vienna", "", Map.of()),
                Arguments.of(getTickets(), "", "Belgrade", Map.of()),
                Arguments.of(getTickets(), "", "", Map.of()),
                Arguments.of(List.of(), "Vienna", "Belgrade", Map.of()),
                Arguments.of(List.of(), "Vienna", "", Map.of()),
                Arguments.of(List.of(), "", "Belgrade", Map.of()),
                Arguments.of(List.of(), "", "", Map.of())
        );
    }

    @ParameterizedTest
    @MethodSource
    void getBusWithMostKMTraveled(List<Ticket> tickets, Optional<Map.Entry<Bus, Integer>> expected) {
        TransportService transportService = new TransportService();
        Optional<Map.Entry<Bus, Integer>> busWithMostDistance = transportService.getBusWithMostKMTraveled(tickets);
        assertEquals(expected, busWithMostDistance);
    }

    static Stream<Arguments> getBusWithMostKMTraveled() {
        return Stream.of(
                Arguments.of(getTickets(), Optional.of(new AbstractMap.SimpleEntry<>(getBuses().get(0), 33))),
                Arguments.of(List.of(), Optional.empty())
        );
    }

    static List<Ticket> getTickets() {
        return List.of(
                new Ticket("1", "Max", LocalDate.now(), getRoutes().get(0), getBuses().get(2)),
                new Ticket("2", "Phillip", LocalDate.now(), getRoutes().get(1), getBuses().get(0)),
                new Ticket("3", "Franz", LocalDate.now(), getRoutes().get(2), getBuses().get(1)),
                new Ticket("4", "Herbert", LocalDate.now(), getRoutes().get(3), getBuses().get(0)),
                new Ticket("5", "Hans", LocalDate.now(), getRoutes().get(4), getBuses().get(4)),
                new Ticket("6", "Karl", LocalDate.now(), getRoutes().get(5), getBuses().get(3)),
                new Ticket("7", "Sebastian", LocalDate.now(), getRoutes().get(6), getBuses().get(2)),
                new Ticket("8", "Joseph", LocalDate.now(), getRoutes().get(10), getBuses().get(4)),
                new Ticket("18", "Peter", LocalDate.now(), getRoutes().get(11), getBuses().get(4)),
                new Ticket("28", "Martin", LocalDate.now(), getRoutes().get(12), getBuses().get(3)),
                new Ticket("38", "Helmut", LocalDate.now(), getRoutes().get(13), getBuses().get(0)),
                new Ticket("48", "Christian", LocalDate.now(), getRoutes().get(13), getBuses().get(0)),
                new Ticket("9", "Michael", LocalDate.now(), getRoutes().get(8), getBuses().get(0)),
                new Ticket("10", "Christopher", LocalDate.now(), getRoutes().get(9), getBuses().get(1))
        );
    }
    static List<Route> getRoutes() {
        return List.of(
                new Route("1", "Vienna", "Belgrade", LocalTime.of(12,0)),
                new Route("11", "Vienna", "Belgrade", LocalTime.of(12,0)),
                new Route("12", "Vienna", "Belgrade", LocalTime.of(12,0)),
                new Route("13", "Vienna", "Belgrade", LocalTime.of(12,0)),
                new Route("2", "Vienna", "Bratislava", LocalTime.of(1,0)),
                new Route("3", "Budapest", "Kiev", LocalTime.of(6,0)),
                new Route("4", "Vienna", "Budapest", LocalTime.of(3, 0)),
                new Route("5", "Barcelona", "Madrid", LocalTime.of(3, 0)),
                new Route("6", "Lisbon", "Porto", LocalTime.of(3, 0)),
                new Route("7", "Novi Sad", "Belgrade", LocalTime.of(1, 45)),
                new Route("8", "Vienna", "Prague", LocalTime.of(3, 0)),
                new Route("18", "Vienna", "Prague", LocalTime.of(3, 0)),
                new Route("28", "Vienna", "Prague", LocalTime.of(3, 0)),
                new Route("38", "Vienna", "Prague", LocalTime.of(3, 0)),
                new Route("9", "Vienna", "Munich", LocalTime.of(4,0)),
                new Route("10", "Nis", "Skopje", LocalTime.of(2,0))
        );
    }
    static List<Bus> getBuses() {
        return List.of(
                new Bus("1", "Mercedes", 40),
                new Bus("2", "MAN", 24),
                new Bus("3", "Volvo", 32),
                new Bus("4", "Renault", 24),
                new Bus("5", "VW", 40)
        );
    }
}