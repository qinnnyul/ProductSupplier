package com.thoughtworks.trains.domain;

import com.thoughtworks.trains.config.StationInfo;

import java.util.ArrayList;
import java.util.List;

public class Station
{
    private StationInfo name;

    private List<Station> allVisitedList = new ArrayList<>();

    public Station(StationInfo name)
    {
        this.name = name;
    }


    public List<Station> getAllVisitedList()
    {
        return allVisitedList;
    }

    public void addToVisitedList(Station station)
    {
        this.allVisitedList.add(station);
    }

    public void clearVisitedList()
    {
        this.allVisitedList.clear();
    }

    public int getIndex()
    {
        return name.getIndex();
    }

}
