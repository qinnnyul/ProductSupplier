package com.symbio.supplier.utils;

import com.symbio.supplier.exceptions.UnparseableStringToDateException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils
{
    public static Date strToDate(String dateString)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return df.parse(dateString);
        } catch (ParseException e) {
            throw new UnparseableStringToDateException();
        }
    }
}
