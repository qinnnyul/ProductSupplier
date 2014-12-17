package com.thoughtworks.trains.service.impl;

import com.thoughtworks.trains.domain.Route;
import com.thoughtworks.trains.domain.Station;
import com.thoughtworks.trains.factory.GraphFactory;
import com.thoughtworks.trains.factory.StationFactory;
import com.thoughtworks.trains.service.RouteCalculatorService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.thoughtworks.trains.config.StationInfo.A;
import static com.thoughtworks.trains.config.StationInfo.B;
import static com.thoughtworks.trains.config.StationInfo.C;
import static com.thoughtworks.trains.config.StationInfo.D;
import static com.thoughtworks.trains.config.StationInfo.E;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DistanceOfRouteCalculatorServiceTest
{
    private RouteCalculatorService routeCalculatorService;

    @Before
    public void setUp() throws Exception
    {
        routeCalculatorService = new DistanceOfRouteCalculatorService(GraphFactory.create(new DataInputServiceImpl()));

    }

    @Test
    public void should_calculate_the_distance_of_AEBCD() throws Exception
    {
        // given
        Station start = StationFactory.build(A);
        Station end = StationFactory.build(D);
        Station[] stations = {start, new Station(E), new Station(B), new Station(C), end};
        Route route = new Route(start, end);
        route.setStations(Arrays.asList(stations));
        // when
        Integer distance = routeCalculatorService.calculate(route);
        // then
        assertThat(distance, is(22));
    }




}