package com.thoughtworks.trains.service.impl;

import com.thoughtworks.trains.domain.Graph;
import com.thoughtworks.trains.domain.Route;
import com.thoughtworks.trains.service.RouteCalculatorService;

public class DistanceOfRouteCalculatorService extends RouteCalculatorService
{
    public DistanceOfRouteCalculatorService(Graph graph)
    {
        super(graph);
    }

    @Override
    public int calculate(Route route)
    {
        return graph.getDistanceOfRoute(route.getDetails());
    }
}
