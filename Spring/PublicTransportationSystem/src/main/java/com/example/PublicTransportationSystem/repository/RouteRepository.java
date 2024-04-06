package com.example.PublicTransportationSystem.repository;

import com.example.PublicTransportationSystem.data.Route;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouteRepository {

    private final List<Route> routes;

    public RouteRepository(List<Route> routes) {
        this.routes = routes;
    }

    public Route add(Route route) {
        routes.add(route);
        return route;
    }

    public List<Route> getRoutes() {
        return routes;
    }
}
