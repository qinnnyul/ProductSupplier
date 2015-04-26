package com.symbio.supplier.domains;

import com.symbio.supplier.exceptions.IllegalCombinatedMaterialsException;

import java.util.List;

public class CombinedMaterials
{
    private List<MaterialSupplyDetail> materialSupplyDetails;

    public CombinedMaterials(List<MaterialSupplyDetail> materialSupplyDetails)
    {
        this.materialSupplyDetails = materialSupplyDetails;
    }

    public CombinedMaterials add(MaterialSupplyDetail materialSupplyDetail)
    {
        materialSupplyDetails.add(materialSupplyDetail);
        return this;
    }

    public List<MaterialSupplyDetail> getMaterialSupplyDetails()
    {
        if (materialSupplyDetails == null || materialSupplyDetails.size() == 0){
            throw new IllegalCombinatedMaterialsException();
        }
        return materialSupplyDetails;
    }
}
