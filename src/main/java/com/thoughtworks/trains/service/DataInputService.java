package com.thoughtworks.trains.service;

import java.io.IOException;

public interface DataInputService
{
    public int[][] loadData(String filename) throws IOException;
}
