package com.thoughtworks.trains.service.impl;

import com.thoughtworks.trains.domain.Counter;
import com.thoughtworks.trains.domain.DistancesCondition;
import com.thoughtworks.trains.domain.Graph;
import com.thoughtworks.trains.domain.Route;
import com.thoughtworks.trains.domain.Station;
import com.thoughtworks.trains.domain.StopsCondition;
import com.thoughtworks.trains.service.RouteCalculatorService;

import java.util.List;

import static com.thoughtworks.trains.config.Constant.ONE;
import static com.thoughtworks.trains.config.Constant.ZERO;

public class NumberOfRouteCalculatorService extends RouteCalculatorService
{
    private DistancesCondition distancesCondition;

    private StopsCondition stopsCondition;

    public NumberOfRouteCalculatorService(Graph graph)
    {
        super(graph);
    }

    public NumberOfRouteCalculatorService withDistanceCondition(DistancesCondition distancesCondition)
    {
        this.distancesCondition = distancesCondition;
        return this;
    }

    public NumberOfRouteCalculatorService withStopsCondition(StopsCondition stopsCondition)
    {
        this.stopsCondition = stopsCondition;
        return this;
    }


    @Override
    public int calculate(Route route)
    {
        Counter counter = new Counter();

        if (stopsCondition != null) {
            countTripsWithStops(route.getSource(), route.getTarget(), ZERO, counter);
        }

        if (distancesCondition != null) {
            countTripsWithDistance(route.getSource(), route.getTarget(), ZERO, counter);
        }

        return counter.getTripCount();
    }

    private void countTripsWithDistance(Station source, Station target, int distance, Counter counter)
    {
        List<Station> nearStations = graph.findNearStations(source);

        for (Station station : nearStations) {
            int current = distance + graph.getDistanceOf(source, station);
            if (target == station && distancesCondition.check(current)) {
                counter.incrementForTripCounter();
            } else if (current > distancesCondition.getValue()) {
                return;
            }
            countTripsWithDistance(station, target, current, counter);
        }
    }

    private void countTripsWithStops(Station source, Station target, int stop, Counter counter)
    {
        List<Station> nearStations = graph.findNearStations(source);

        for (Station station : nearStations) {
            int current = stop + ONE;
            if (target == station && stopsCondition.check(current)) {
                counter.incrementForTripCounter();
                return;
            } else if (current > stopsCondition.getValue()) {
                return;
            }
            countTripsWithStops(station, target, current, counter);
        }
    }

}
