package com.thoughtworks.trains.service.impl;

import com.thoughtworks.trains.domain.DistancesCondition;
import com.thoughtworks.trains.domain.Graph;
import com.thoughtworks.trains.domain.Route;
import com.thoughtworks.trains.factory.GraphFactory;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static com.thoughtworks.trains.config.StationInfo.C;
import static com.thoughtworks.trains.domain.Operator.LESSTHAN;
import static com.thoughtworks.trains.factory.StationFactory.build;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumberOfRouteWithDistancesCalculatorServiceTest
{
    private NumberOfRouteCalculatorService classUnderTest;

    private Graph graph;

    @Before
    public void setUp() throws Exception
    {
        graph = GraphFactory.create(new DataInputServiceImpl());
    }

    @Test
    public void should_get_trips_for_two_stations_with_distance_as_condition_C2C() throws Exception
    {
        // given
        classUnderTest = new NumberOfRouteWithDistancesCalculatorService(graph, new DistancesCondition(LESSTHAN, 30));
        // when
        int number = classUnderTest.calculate(new Route(build(C), build(C)));
        // then
        assertThat(number, is(7));
    }


}