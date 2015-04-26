package com.symbio.supplier.domains;

import com.google.common.collect.ImmutableList;

import java.util.List;

import static com.symbio.supplier.domains.MaterialSupplyDetail.*;


public enum MaterialCategory
{

    RAW_EUCALYPTUS_001(ImmutableList.<MaterialSupplyDetail>builder().add(RAW_EUCALYPTUS_001_ONE).add(RAW_EUCALYPTUS_001_TWO).build()),

    RAW_ROSE_005(ImmutableList.<MaterialSupplyDetail>builder().add(RAW_ROSE_005_ONE).add(RAW_ROSE_005_TWO).build()),

    CAPACITY(ImmutableList.<MaterialSupplyDetail>builder().add(MaterialSupplyDetail.CAPACITY).build());

    private List<MaterialSupplyDetail> materialSupplyDetails;

    MaterialCategory(List<MaterialSupplyDetail> materialSupplyDetails)
    {
        this.materialSupplyDetails = materialSupplyDetails;
    }

    public List<MaterialSupplyDetail> getMaterialSupplyDetails()
    {
        return materialSupplyDetails;
    }

    public boolean hasContains(MaterialSupplyDetail materialSupplyDetail){
        return materialSupplyDetails.contains(materialSupplyDetail);
    }
}
