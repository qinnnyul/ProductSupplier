package com.thoughtworks.trains.factory;

import com.thoughtworks.trains.domain.Graph;
import com.thoughtworks.trains.service.DataInputService;

import java.io.IOException;

import static com.thoughtworks.trains.config.Constant.TEST_FILE_NAME;

public class GraphFactory
{
    public static Graph create(DataInputService dataInputService) throws IOException
    {
        int[][] edges = dataInputService.loadData(TEST_FILE_NAME);
        return new Graph(StationFactory.buildStations(), edges);
    }
}
