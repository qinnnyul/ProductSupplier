package com.thoughtworks.trains.service.impl;

import com.thoughtworks.trains.domain.Condition;
import com.thoughtworks.trains.domain.Graph;
import com.thoughtworks.trains.domain.Station;

public class NumberOfRouteWithStopsCalculatorService extends NumberOfRouteCalculatorService
{
    public NumberOfRouteWithStopsCalculatorService(Graph graph, Condition condition)
    {
        super(graph, condition);
    }

    @Override
    public int getCurrentValue(Station source, Station target, int stop)
    {
        return stop + 1;
    }
}
