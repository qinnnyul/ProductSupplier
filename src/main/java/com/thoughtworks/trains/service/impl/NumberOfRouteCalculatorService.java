package com.thoughtworks.trains.service.impl;

import com.thoughtworks.trains.domain.Condition;
import com.thoughtworks.trains.domain.Counter;
import com.thoughtworks.trains.domain.Graph;
import com.thoughtworks.trains.domain.Route;
import com.thoughtworks.trains.domain.Station;
import com.thoughtworks.trains.domain.StopsCondition;
import com.thoughtworks.trains.service.RouteCalculatorService;

import java.util.List;

import static com.thoughtworks.trains.config.Constant.ZERO;

public abstract class NumberOfRouteCalculatorService extends RouteCalculatorService
{
    private Condition condition;

    protected NumberOfRouteCalculatorService(Graph graph, Condition condition)
    {
        super(graph);
        this.condition = condition;
    }

    @Override
    public int calculate(Route route)
    {
        Counter counter = new Counter();
        countNumberOfRoute(route.getSource(), route.getTarget(), ZERO, counter);
        return counter.getTripCount();
    }

    private void countNumberOfRoute(Station source, Station target, int temp, Counter counter)
    {
        List<Station> nearStations = graph.findNearStations(source);

        for (Station station : nearStations) {
            int current = getCurrentValue(source, station, temp);
            if (target == station && condition.check(current)) {
                counter.incrementForTripCounter();
                if (condition instanceof StopsCondition) {
                    return;
                }
            } else if (current > condition.getValue()) {
                return;
            }
            countNumberOfRoute(station, target, current, counter);
        }

    }

    public abstract int getCurrentValue(Station source, Station target, int temp);

}
