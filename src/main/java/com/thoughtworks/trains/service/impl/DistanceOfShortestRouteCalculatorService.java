package com.thoughtworks.trains.service.impl;

import com.thoughtworks.trains.domain.Graph;
import com.thoughtworks.trains.domain.Route;
import com.thoughtworks.trains.domain.Station;
import com.thoughtworks.trains.exception.NoSuchRouteException;
import com.thoughtworks.trains.service.RouteCalculatorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.thoughtworks.trains.config.Constant.ERROR;
import static com.thoughtworks.trains.config.Constant.NO_SUCH_ROUTE_ERROR;
import static com.thoughtworks.trains.config.Constant.ONE;
import static com.thoughtworks.trains.config.Constant.STATIONS_SIZE;
import static com.thoughtworks.trains.config.Constant.ZERO;

public class DistanceOfShortestRouteCalculatorService extends RouteCalculatorService
{
    private Station source;

    private final Stack<Station> stack = new Stack<>();

    public DistanceOfShortestRouteCalculatorService(Graph graph)
    {
        super(graph);
    }

    @Override
    public int calculate(Route route)
    {
        this.source = route.getSource();
        return getDistanceOfShortestRoute(route.getSource(), route.getTarget());
    }


    private Integer getDistanceOfShortestRoute(Station source, Station target)
    {
        List<List<Station>> routes = getRoutes(source, target);
        if (routes.size() == ZERO) {
            return ERROR;
        }
        Integer shortest = graph.getDistanceOfRoute(routes.get(ZERO));

        if (routes.size() > ONE) {
            for (int i = ONE; i < routes.size(); i++) {

                Integer distance = graph.getDistanceOfRoute(routes.get(i));
                if (shortest > distance) {
                    shortest = distance;
                }
            }
        }

        return shortest;
    }

    private List<List<Station>> getRoutes(Station source, Station target)
    {
        List<List<Station>> routes = new ArrayList<>();
        if (!graph.isConnectible(source, target)) {
            throw new NoSuchRouteException(NO_SUCH_ROUTE_ERROR);
        }
        stack.push(source);

        while (!stack.isEmpty()) {
            int nearestUnvisitedStation = getNearestUnvisitedStation(stack.peek());
            if (nearestUnvisitedStation == ERROR) {
                stack.peek().clearVisitedList();
                stack.pop();
            } else {
                stack.push(graph.getStationByIndex(nearestUnvisitedStation));
            }

            if (!stack.isEmpty() && target == stack.peek() && stack.size() > ONE) {
                routes.add(getRouteDetailFrom(stack));
                stack.pop();
            }

        }

        return routes;
    }

    private int getNearestUnvisitedStation(Station station)
    {
        List<Station> allVisitedList = station.getAllVisitedList();
        for (int i = ZERO; i < STATIONS_SIZE; i++) {
            Integer distance = graph.getEdges()[station.getIndex()][i];
            Station nearStation = graph.getStationByIndex(i);

            if (isNearestUnvistedStation(allVisitedList, distance, nearStation)) {
                station.addToVisitedList(nearStation);
                return nearStation.getIndex();
            }


        }
        return ERROR;
    }

    private boolean isNearestUnvistedStation(List<Station> allVisitedList, Integer distance, Station nearStation)
    {
        return distance > ZERO && !allVisitedList.contains(nearStation) && (!stack.contains(nearStation) || nearStation.equals(source));
    }

    private List<Station> getRouteDetailFrom(Stack<Station> stack)
    {
        List<Station> stations = new ArrayList<>();

        for (Station station : stack) {
            stations.add(station);
        }

        return stations;
    }
}
