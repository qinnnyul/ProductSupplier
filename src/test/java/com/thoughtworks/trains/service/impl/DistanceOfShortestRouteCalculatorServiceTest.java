package com.thoughtworks.trains.service.impl;

import com.thoughtworks.trains.domain.Route;
import com.thoughtworks.trains.factory.GraphFactory;
import com.thoughtworks.trains.factory.StationFactory;
import org.junit.Before;
import org.junit.Test;

import static com.thoughtworks.trains.config.StationInfo.A;
import static com.thoughtworks.trains.config.StationInfo.B;
import static com.thoughtworks.trains.config.StationInfo.C;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DistanceOfShortestRouteCalculatorServiceTest
{

    private DistanceOfShortestRouteCalculatorService classUnderTest;

    @Before
    public void setUp() throws Exception
    {
        this.classUnderTest = new DistanceOfShortestRouteCalculatorService(GraphFactory.create(new DataInputServiceImpl()));

    }


    @Test
    public void should_get_the_shortest_routes_for_A2C() throws Exception
    {
        // given
        Route route = new Route(StationFactory.build(A), StationFactory.build(C));
        // when
        Integer shortestPath = classUnderTest.calculate(route);
        // then
        assertThat(shortestPath, is(9));
    }


    @Test
    public void should_get_the_shortest_routes_for_B2B() throws Exception
    {
        // given
        Route route = new Route(StationFactory.build(B), StationFactory.build(B));
        // when
        Integer shortestPath = classUnderTest.calculate(route);
        // then
        assertThat(shortestPath, is(9));
    }

}