package com.thoughtworks.trains.domain;

import com.thoughtworks.trains.exception.NoSuchRouteException;

import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.trains.config.Constant.NO_SUCH_ROUTE_ERROR;
import static com.thoughtworks.trains.config.Constant.ONE;
import static com.thoughtworks.trains.config.Constant.STATIONS_SIZE;
import static com.thoughtworks.trains.config.Constant.ZERO;

public class Graph
{
    private final Station[] stations;
    private final int[][] edges;

    public Graph(Station[] stations, int[][] edges)
    {
        this.stations = stations;
        this.edges = edges;
    }

    public Integer getDistanceOf(Station source, Station target)
    {
        return edges[source.getIndex()][target.getIndex()];
    }


    public Integer getDistanceOfRoute(List<Station> stations)
    {
        Station start = stations.get(ZERO);
        Integer sum = ZERO;
        if (stations.size() > ONE) {
            for (int i = ONE; i < stations.size(); i++) {
                Integer distance = getDistanceOf(start, stations.get(i));
                if (distance == ZERO) {
                    throw new NoSuchRouteException(NO_SUCH_ROUTE_ERROR);
                }
                sum += distance;
                start = stations.get(i);
            }
        }
        return sum;
    }

    public boolean isConnectible(Station source, Station target)
    {
        List<Integer> queue = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        int start = source.getIndex();

        queue.add(start);
        while (!queue.isEmpty()) {
            for (int i = ZERO; i < STATIONS_SIZE; i++) {
                if (edges[start][i] > ZERO && !visited.contains(i)) {
                    queue.add(i);
                }
            }
            if (queue.contains(target.getIndex())) {
                return true;
            } else {
                visited.add(queue.get(ZERO));
                queue.remove(ZERO);

                if (!queue.isEmpty()) {
                    start = queue.get(ZERO);
                }

            }

        }
        return false;
    }

    public Station getStationByIndex(int index)
    {
        return stations[index];
    }

    public List<Station> findNearStations(Station station)
    {
        List<Station> nearStations = new ArrayList<>();
        for (int i = ZERO; i < STATIONS_SIZE; i++) {
            if (edges[station.getIndex()][i] > ZERO) {
                nearStations.add(stations[i]);
            }
        }

        return nearStations;
    }

    public int[][] getEdges()
    {
        return edges;
    }
}
