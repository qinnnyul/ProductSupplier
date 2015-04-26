package com.symbio.supplier.utils;


import com.symbio.supplier.exceptions.UnparseableStringToDateException;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

public class DateUtilsTest
{
    @Test
    public void should_parse_string_to_date() throws Exception
    {
        // when
        Date date = DateUtils.strToDate("2014-01-01 00:00:00");

        // then
        assertNotNull(date);
    }

    @Test(expected = UnparseableStringToDateException.class)
    public void should_be_ware_of_an_exception_will_be_throw_out_if_string_is_unparasble() throws Exception
    {
        // when
        DateUtils.strToDate("2014/04/05");
    }
}