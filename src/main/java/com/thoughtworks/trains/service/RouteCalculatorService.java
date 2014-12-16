package com.thoughtworks.trains.service;

import com.thoughtworks.trains.domain.Graph;
import com.thoughtworks.trains.domain.Route;

public abstract class RouteCalculatorService
{
    protected Graph graph;

    protected RouteCalculatorService(Graph graph)
    {
        this.graph = graph;
    }

    public abstract int calculate(Route route);
}
