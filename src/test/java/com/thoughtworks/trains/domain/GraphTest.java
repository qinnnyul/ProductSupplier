package com.thoughtworks.trains.domain;

import com.thoughtworks.trains.exception.NoSuchRouteException;
import com.thoughtworks.trains.factory.GraphFactory;
import com.thoughtworks.trains.service.impl.DataInputServiceImpl;
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

public class GraphTest
{

    private Graph graph;

    @Before
    public void setUp() throws Exception
    {
        graph = GraphFactory.create(new DataInputServiceImpl());

    }

    @Test
    public void should_return_5_for_the_distance_of_AB() throws Exception
    {
        // given
        // when
        Integer distance = graph.getDistanceOf(new Station(A), new Station(B));
        // then
        assertThat(distance, is(5));
    }


    @Test
    public void should_return_5_for_the_distance_of_AD() throws Exception
    {
        // given
        // when
        Integer distance = graph.getDistanceOf(new Station(A), new Station(D));
        // then
        assertThat(distance, is(5));
    }


    @Test
    public void should_return_7_for_the_distance_of_AE() throws Exception
    {
        // given
        // when
        Integer distance = graph.getDistanceOf(new Station(A), new Station(E));
        // then
        assertThat(distance, is(7));
    }

    @Test
    public void should_get_the_distance_of_route_AEBCD() throws Exception
    {
        // given
        Station[] stations = {new Station(A), new Station(E), new Station(B), new Station(C), new Station(D)};
        // when
        Integer distanceOfRoute = graph.getDistanceOfRoute(Arrays.asList(stations));
        // then
        assertThat(distanceOfRoute, is(22));
    }

    @Test
    public void should_get_the_distance_of_route_ABC() throws Exception
    {
        // given
        Station[] stations = {new Station(A), new Station(B), new Station(C)};
        // when
        Integer distanceOfRoute = graph.getDistanceOfRoute(Arrays.asList(stations));
        // then
        assertThat(distanceOfRoute, is(9));
    }

    @Test
    public void should_get_the_distance_of_route_ADC() throws Exception
    {
        // given
        Station[] stations = {new Station(A), new Station(D), new Station(C)};
        // when
        Integer distanceOfRoute = graph.getDistanceOfRoute(Arrays.asList(stations));
        // then
        assertThat(distanceOfRoute, is(13));
    }

    @Test(expected = NoSuchRouteException.class)
    public void should_throw_exception_for_route_AED() throws Exception
    {
        // given
        Station[] stations = {new Station(A), new Station(E), new Station(D)};
        // when
        graph.getDistanceOfRoute(Arrays.asList(stations));
        // then
    }


}