package com.thoughtworks.trains.config;

public class Constant
{
    //NUMBER
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int ERROR = -1;


    //ERROR MSG
    public static final String INVALID_DATA_ERROR = "INVALID INPUT DATA ERROR";
    public static final String NO_SUCH_NAME_IN_STATIONS_ERROR = "NO SUCH NAME IN STATIONS ERROR";
    public static final String NO_SUCH_OPERATOR_ERROR = "NO SUCH OPERATOR ERROR";
    public static final String NO_SUCH_ROUTE_ERROR = "NO SUCH ROUTE ERROR";


    //OTHER
    public static final String SEPARATOR = ",";
    public static final int STATIONS_SIZE = StationInfo.values().length;
    public static final String TEST_FILE_NAME = "testdata";
}
