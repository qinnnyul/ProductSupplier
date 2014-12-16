package com.thoughtworks.trains.service.impl;

import com.thoughtworks.trains.domain.Condition;
import com.thoughtworks.trains.domain.Graph;
import com.thoughtworks.trains.domain.Station;

public class NumberOfRouteWithDistancesCalculatorService extends NumberOfRouteCalculatorService
{
    public NumberOfRouteWithDistancesCalculatorService(Graph graph, Condition condition)
    {
        super(graph, condition);
    }

    @Override
    public int getCurrentValue(Station source, Station target, int distance)
    {
        return distance + graph.getDistanceOf(source, target);
    }
}
