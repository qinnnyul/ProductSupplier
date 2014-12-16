package com.thoughtworks.trains.service.impl;

import com.thoughtworks.trains.exception.InvalidDataException;
import org.junit.Before;
import org.junit.Test;

import static com.thoughtworks.trains.config.Constant.STATIONS_SIZE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DataInputServiceImplTest
{

    private DataInputServiceImpl dataInputService;

    @Before
    public void setUp() throws Exception
    {
        dataInputService = new DataInputServiceImpl();
    }

    @Test
    public void should_load_data_from_file() throws Exception
    {
        // when
        int[][] edges = dataInputService.loadData("testdata");

        // then
        assertThat(edges.length, is(STATIONS_SIZE));
    }

    @Test(expected = NullPointerException.class)
    public void should_throw_out_exception_when_file_not_exit() throws Exception
    {
        // when
        dataInputService.loadData("NoExistedFile");
    }

    @Test(expected = InvalidDataException.class)
    public void should_throw_out_exception_when_data_is_invalid() throws Exception
    {
        // when
        dataInputService.loadData("invalidtestdata");
    }
}