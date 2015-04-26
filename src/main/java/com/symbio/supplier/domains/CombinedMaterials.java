package com.symbio.supplier.domains;

import com.symbio.supplier.exceptions.IllegalCombinatedMaterialsException;

import java.util.List;

public class CombinedMaterials
{
    private List<MaterialDetail> materialDetails;

    public CombinedMaterials(List<MaterialDetail> materialDetails)
    {
        this.materialDetails = materialDetails;
    }

    public CombinedMaterials add(MaterialDetail materialDetail)
    {
        materialDetails.add(materialDetail);
        return this;
    }

    public List<MaterialDetail> getMaterialDetails()
    {
        if (materialDetails == null || materialDetails.size() == 0){
            throw new IllegalCombinatedMaterialsException();
        }
        return materialDetails;
    }
}
