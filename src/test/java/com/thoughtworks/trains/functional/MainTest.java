package com.thoughtworks.trains.functional;

import com.thoughtworks.trains.domain.DistancesCondition;
import com.thoughtworks.trains.domain.Graph;
import com.thoughtworks.trains.domain.Route;
import com.thoughtworks.trains.domain.Station;
import com.thoughtworks.trains.domain.StopsCondition;
import com.thoughtworks.trains.exception.NoSuchRouteException;
import com.thoughtworks.trains.factory.GraphFactory;
import com.thoughtworks.trains.factory.StationFactory;
import com.thoughtworks.trains.service.RouteCalculatorService;
import com.thoughtworks.trains.service.impl.DataInputServiceImpl;
import com.thoughtworks.trains.service.impl.DistanceOfRouteCalculatorService;
import com.thoughtworks.trains.service.impl.DistanceOfShortestRouteCalculatorService;
import com.thoughtworks.trains.service.impl.NumberOfRouteWithDistancesCalculatorService;
import com.thoughtworks.trains.service.impl.NumberOfRouteWithStopsCalculatorService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.thoughtworks.trains.config.StationInfo.A;
import static com.thoughtworks.trains.config.StationInfo.B;
import static com.thoughtworks.trains.config.StationInfo.C;
import static com.thoughtworks.trains.config.StationInfo.D;
import static com.thoughtworks.trains.config.StationInfo.E;
import static com.thoughtworks.trains.domain.Operator.EQUALS;
import static com.thoughtworks.trains.domain.Operator.LESSER_OR_EQUAL;
import static com.thoughtworks.trains.domain.Operator.LESSTHAN;

/*
Use Class As Functional Test To Cover All Requirement
 */
public class MainTest
{
    private Graph graph;

    private RouteCalculatorService routeCalculatorService;
    private Station source;
    private Station target;
    private Route route;

    @Before
    public void setUp() throws Exception
    {
        graph = GraphFactory.create(new DataInputServiceImpl());
    }

    @Test
    public void should_cover_all_requirement_as_functional_test() throws Exception
    {
        /*
        1. The distance of the route A-B-C.
         */
        source = StationFactory.build(A);
        target = StationFactory.build(C);
        route = new Route(source, target);
        route.setStations(Arrays.asList(source, StationFactory.build(B), target));

        routeCalculatorService = new DistanceOfRouteCalculatorService(graph);

        System.out.println(String.format("#1:%s", routeCalculatorService.calculate(route)));

        /*
        2. The distance of the route A-D.
         */
        source = StationFactory.build(A);
        target = StationFactory.build(D);
        route = new Route(source, target);
        route.setStations(Arrays.asList(source, target));

        System.out.println(String.format("#2:%s", routeCalculatorService.calculate(route)));

        /*
        3. The distance of the route A-D-C.
         */

        source = StationFactory.build(A);
        target = StationFactory.build(C);
        route = new Route(source, target);
        route.setStations(Arrays.asList(source, StationFactory.build(D), target));

        System.out.println(String.format("#3:%s", routeCalculatorService.calculate(route)));

        /*
        4. The distance of the route A-E-B-C-D.
         */

        source = StationFactory.build(A);
        target = StationFactory.build(D);
        route = new Route(source, target);
        route.setStations(Arrays.asList(source, StationFactory.build(E), StationFactory.build(B), StationFactory.build(C), target));

        System.out.println(String.format("#4:%s", routeCalculatorService.calculate(route)));

        /*
        5. The distance of the route A-E-D.
         */

        source = StationFactory.build(A);
        target = StationFactory.build(D);
        route = new Route(source, target);
        route.setStations(Arrays.asList(source, StationFactory.build(E), target));

        String message = "";
        try {
            routeCalculatorService.calculate(route);
        } catch (NoSuchRouteException e) {
            message = e.getMessage();
        }

        System.out.println(String.format("#5:%s", message));

        /*
        6. The number of trips starting at C and ending at C with a maximum of 3 stops. In the sample data
        below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).
         */

        source = StationFactory.build(C);
        target = StationFactory.build(C);
        route = new Route(source, target);

        routeCalculatorService = new NumberOfRouteWithStopsCalculatorService(graph, new StopsCondition(LESSER_OR_EQUAL, 3));

        System.out.println(String.format("#6:%s", routeCalculatorService.calculate(route)));


        /*
        7. The number of trips starting at A and ending at C with exactly 4 stops. In the sample data below,
        there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).
         */

        source = StationFactory.build(A);
        target = StationFactory.build(C);
        route = new Route(source, target);

        routeCalculatorService = new NumberOfRouteWithStopsCalculatorService(graph, new StopsCondition(EQUALS, 4));

        System.out.println(String.format("#7:%s", routeCalculatorService.calculate(route)));

        /*
        8. The length of the shortest route (in terms of distance to travel) from A to C.
         */

        source = StationFactory.build(A);
        target = StationFactory.build(C);
        route = new Route(source, target);

        routeCalculatorService = new DistanceOfShortestRouteCalculatorService(graph);

        System.out.println(String.format("#8:%s", routeCalculatorService.calculate(route)));


        /*
        9. The length of the shortest route (in terms of distance to travel) from B to B.
         */

        source = StationFactory.build(B);
        target = StationFactory.build(B);
        route = new Route(source, target);

        routeCalculatorService = new DistanceOfShortestRouteCalculatorService(graph);

        System.out.println(String.format("#9:%s", routeCalculatorService.calculate(route)));

        /*
        10.The number of different routes from C to C with a distance of less than 30. In the sample data, the
        trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.
         */

        source = StationFactory.build(C);
        target = StationFactory.build(C);
        route = new Route(source, target);

        routeCalculatorService = new NumberOfRouteWithDistancesCalculatorService(graph, new DistancesCondition(LESSTHAN, 30));

        System.out.println(String.format("#10:%s", routeCalculatorService.calculate(route)));

    }
}
