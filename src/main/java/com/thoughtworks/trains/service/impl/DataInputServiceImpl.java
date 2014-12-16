package com.thoughtworks.trains.service.impl;

import com.thoughtworks.trains.config.StationInfo;
import com.thoughtworks.trains.domain.Station;
import com.thoughtworks.trains.exception.InvalidDataException;
import com.thoughtworks.trains.factory.StationFactory;
import com.thoughtworks.trains.service.DataInputService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.thoughtworks.trains.config.Constant.INVALID_DATA_ERROR;
import static com.thoughtworks.trains.config.Constant.SEPARATOR;
import static com.thoughtworks.trains.config.Constant.STATIONS_SIZE;

public class DataInputServiceImpl implements DataInputService
{

    @Override
    public int[][] loadData(String filename) throws IOException
    {
        return parseDataAndValidate(loadDataFromFile(filename).split(SEPARATOR));
    }


    private int[][] parseDataAndValidate(String[] items)
    {
        int[][] edges = new int[STATIONS_SIZE][STATIONS_SIZE];
        for (String item : items) {
            parseDataAndValidateForEachItem(edges, item);
        }
        return edges;
    }

    private void parseDataAndValidateForEachItem(int[][] edges, String item) throws InvalidDataException
    {
        String regex = ".*([A-E])([A-E])([0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(item);
        if (matcher.matches()) {
            Station start = StationFactory.build(StationInfo.getStationInfoByName(matcher.group(1).toCharArray()[0]));
            Station end = StationFactory.build(StationInfo.getStationInfoByName(matcher.group(2).toCharArray()[0]));
            edges[start.getIndex()][end.getIndex()] = Integer.valueOf(matcher.group(3));
        } else {
            throw new InvalidDataException(INVALID_DATA_ERROR);
        }
    }

    private String loadDataFromFile(String filename) throws IOException
    {
        InputStream input = this.getClass().getClassLoader().getResourceAsStream(filename);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
        String line = buffer.readLine();
        buffer.close();
        input.close();
        return line;
    }
}
