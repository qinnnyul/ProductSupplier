package com.symbio.supplier.domains;

import java.util.List;

public class Material
{
    private final MaterialCategory materialCategory;
    private final int amount;

    public Material(MaterialCategory materialCategory, int amount)
    {

        this.materialCategory = materialCategory;
        this.amount = amount;
    }

    public List<MaterialSupplyDetail> getMaterialSupplyDetails()
    {
        return materialCategory.getMaterialSupplyDetails();
    }

    public int getAmount()
    {
        return amount;
    }

    public MaterialCategory getMaterialCategory()
    {
        return materialCategory;
    }
}
