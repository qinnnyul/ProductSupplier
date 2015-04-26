package com.symbio.supplier.domains;

public enum MaterialSupplyDetail
{
    RAW_EUCALYPTUS_001_ONE("2014-02-04 00:00:00", "2014-11-31 00:00:00", 6000),
    RAW_EUCALYPTUS_001_TWO("2015-02-01 00:00:00", "2038-01-19 00:00:00", 6000),
    RAW_ROSE_005_ONE("2014-10-01 00:00:00", "2014-10-31 00:00:00", 18),
    RAW_ROSE_005_TWO("2015-01-01 00:00:00", "2015-01-31 00:00:00", 666),
    CAPACITY("2014-02-04 00:00:00", "2015-01-15 00:00:00", 999);


    private String startDate;
    private String endDate;
    private int amount;

    MaterialSupplyDetail(String startDate, String endDate, int amount)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public int getAmount()
    {
        return amount;
    }


}
