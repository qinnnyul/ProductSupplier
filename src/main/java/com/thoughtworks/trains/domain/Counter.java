package com.thoughtworks.trains.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter
{
    private final AtomicInteger tripCounter = new AtomicInteger(0);

    public int incrementForTripCounter()
    {
        return tripCounter.incrementAndGet();
    }

    public int getTripCount()
    {
        return tripCounter.get();
    }

}
