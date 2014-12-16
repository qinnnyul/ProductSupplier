package com.thoughtworks.trains.config;

import com.thoughtworks.trains.exception.NoSuchNameInStationsException;

import static com.thoughtworks.trains.config.Constant.NO_SUCH_NAME_IN_STATIONS_ERROR;

public enum StationInfo
{
    A(0, 'A'), B(1, 'B'), C(2, 'C'), D(3, 'D'), E(4, 'E');

    private final int index;

    private final char name;

    StationInfo(int index, char name)
    {
        this.index = index;
        this.name = name;
    }

    public int getIndex()
    {
        return index;
    }

    public char getName()
    {
        return name;
    }

    public static StationInfo getStationInfoByName(char name)
    {
        for (StationInfo stationInfo : StationInfo.values()) {
            if (stationInfo.getName() == name) {
                return stationInfo;
            }
        }
        throw new NoSuchNameInStationsException(NO_SUCH_NAME_IN_STATIONS_ERROR);
    }
}
