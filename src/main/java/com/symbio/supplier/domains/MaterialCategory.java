package com.symbio.supplier.domains;

import com.google.common.collect.ImmutableList;

import java.util.List;

import static com.symbio.supplier.domains.MaterialDetail.*;


public enum MaterialCategory
{

    RAW_EUCALYPTUS_001(ImmutableList.<MaterialDetail>builder().add(RAW_EUCALYPTUS_001_ONE).add(RAW_EUCALYPTUS_001_TWO).build()),

    RAW_ROSE_005(ImmutableList.<MaterialDetail>builder().add(RAW_ROSE_005_ONE).add(RAW_ROSE_005_TWO).build()),

    CAPACITY(ImmutableList.<MaterialDetail>builder().add(MaterialDetail.CAPACITY).build());

    private List<MaterialDetail> materialDetails;

    MaterialCategory(List<MaterialDetail> materialDetails)
    {
        this.materialDetails = materialDetails;
    }

    public List<MaterialDetail> getMaterialDetails()
    {
        return materialDetails;
    }

    public boolean hasContains(MaterialDetail materialDetail){
        return materialDetails.contains(materialDetail);
    }
}
