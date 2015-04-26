package com.symbio.supplier.domains;

import org.junit.Test;

import java.util.List;

import static com.symbio.supplier.domains.MaterialCategory.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaterialTest
{
    @Test
    public void should_get_supply_details_for_material_RAW_ROSE_005() throws Exception
    {
        // given
        Material material = new Material(RAW_ROSE_005, 14);
        // when
        List<MaterialDetail> materialDetails = material.getMaterialDetails();

        // then
        assertThat(materialDetails.size(), is(2));
    }


    @Test
    public void should_get_supply_details_for_material_RAW_EUCALYPTUS_001() throws Exception
    {
        // given
        Material material = new Material(RAW_EUCALYPTUS_001, 14);
        // when
        List<MaterialDetail> materialDetails = material.getMaterialDetails();

        // then
        assertThat(materialDetails.size(), is(2));
    }

    @Test
    public void should_get_supply_details_for_material_CAPACITY() throws Exception
    {
        // given
        Material material = new Material(CAPACITY, 14);
        // when
        List<MaterialDetail> materialDetails = material.getMaterialDetails();

        // then
        assertThat(materialDetails.size(), is(1));
    }

    @Test
    public void should_get_material_amount() throws Exception
    {
        // given
        Material material = new Material(CAPACITY, 14);
        // when
        int amount = material.getAmount();
        // then
        assertThat(amount, is(14));
    }

}
