package com.thoughtworks.trains.service.impl;

import com.thoughtworks.trains.domain.DistancesCondition;
import com.thoughtworks.trains.domain.Route;
import com.thoughtworks.trains.domain.StopsCondition;
import com.thoughtworks.trains.factory.GraphFactory;
import org.junit.Before;
import org.junit.Test;

import static com.thoughtworks.trains.config.StationInfo.A;
import static com.thoughtworks.trains.config.StationInfo.C;
import static com.thoughtworks.trains.domain.Operator.EQUALS;
import static com.thoughtworks.trains.domain.Operator.LESSER_OR_EQUAL;
import static com.thoughtworks.trains.domain.Operator.LESSTHAN;
import static com.thoughtworks.trains.factory.StationFactory.build;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NumberOfRouteCalculatorServiceTest
{

    private NumberOfRouteCalculatorService classUnderTest;

    @Before
    public void setUp() throws Exception
    {
        classUnderTest = new NumberOfRouteCalculatorService(GraphFactory.create(new DataInputServiceImpl()));
    }

    @Test
    public void should_get_trips_for_two_stations_with_stops_as_condition_for_C2C() throws Exception
    {
        // given
        classUnderTest.withStopsCondition(new StopsCondition(LESSER_OR_EQUAL, 3));
        // when
        int number = classUnderTest.calculate(new Route(build(C), build(C)));
        // then
        assertThat(number, is(2));
    }


    @Test
    public void should_get_trips_for_two_stations_with_stops_as_condition_A2C() throws Exception
    {
        // given
        classUnderTest.withStopsCondition(new StopsCondition(EQUALS, 4));
        // when
        int number = classUnderTest.calculate(new Route(build(A), build(C)));
        // then
        assertThat(number, is(3));
    }

    @Test
    public void should_get_trips_for_two_stations_with_distance_as_condition_C2C() throws Exception
    {
        // given
        classUnderTest.withDistanceCondition(new DistancesCondition(LESSTHAN, 30));
        // when
        int number = classUnderTest.calculate(new Route(build(C), build(C)));
        // then
        assertThat(number, is(7));
    }

}
