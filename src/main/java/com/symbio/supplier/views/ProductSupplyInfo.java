package com.symbio.supplier.views;

public class ProductSupplyInfo
{
    private String productName;

    private String startDate;

    private String endDate;

    private int amount;

    public ProductSupplyInfo(String productName, String startDate, String endDate, int amount)
    {
        this.productName = productName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
    }
}


