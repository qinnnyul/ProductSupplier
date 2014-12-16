package com.thoughtworks.trains.factory;

import com.thoughtworks.trains.config.StationInfo;
import com.thoughtworks.trains.domain.Station;

import static com.thoughtworks.trains.config.StationInfo.A;
import static com.thoughtworks.trains.config.StationInfo.B;
import static com.thoughtworks.trains.config.StationInfo.C;
import static com.thoughtworks.trains.config.StationInfo.D;
import static com.thoughtworks.trains.config.StationInfo.E;

public class StationFactory
{
    private StationFactory()
    {
    }

    private static final Station[] stations = new Station[]{new Station(A), new Station(B), new Station(C), new Station(D), new Station(E)};

    public static Station build(StationInfo stationInfo)
    {
        return stations[stationInfo.getIndex()];
    }

    public static Station[] buildStations()
    {
        return stations;
    }
}
