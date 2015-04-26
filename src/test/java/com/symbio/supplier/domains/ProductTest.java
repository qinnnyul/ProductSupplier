package com.symbio.supplier.domains;

import com.google.common.collect.ImmutableList;
import com.symbio.supplier.exceptions.InvalidTimeWindowException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.symbio.supplier.domains.MaterialSupplyDetail.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ProductTest
{
    private Product product98100201;

    private Product product98102601;


    @Before
    public void setUp() throws Exception
    {
        List<Material> materials = ImmutableList.<Material>builder()
                .add(new Material(MaterialCategory.CAPACITY, 1))
                .add(new Material(MaterialCategory.RAW_ROSE_005, 14))
                .build();

        List<Material> materials2 = ImmutableList.<Material>builder()
                .add(new Material(MaterialCategory.CAPACITY, 1))
                .add(new Material(MaterialCategory.RAW_ROSE_005, 12))
                .add(new Material(MaterialCategory.RAW_EUCALYPTUS_001, 4))
                .build();

        product98100201 = new Product("98100201", materials);
        product98102601 = new Product("98102601", materials2);
    }

    @Test
    public void should_caculate_beginning_supply_date_for_98100201_case_one() throws Exception
    {
        // given
        List<MaterialSupplyDetail> materialSupplyDetails = newArrayList(ImmutableList.<MaterialSupplyDetail>builder().add(CAPACITY).add(RAW_ROSE_005_ONE).build());
        // when
        String result = product98100201.calculateBeginningDate(new CombinedMaterials(materialSupplyDetails));
        // then
        assertThat(result, is("2014-10-01 00:00:00"));
    }


    @Test
    public void should_caculate_end_supply_date_for_98100201_case_one() throws Exception
    {
        // given
        List<MaterialSupplyDetail> materialSupplyDetails = newArrayList(ImmutableList.<MaterialSupplyDetail>builder().add(CAPACITY).add(RAW_ROSE_005_ONE).build());
        // when
        String result = product98100201.calculateEndDate(new CombinedMaterials(materialSupplyDetails));
        // then
        assertThat(result, is("2014-10-31 00:00:00"));
    }

    @Test
    public void should_caculate_supply_amount_for_98100201_case_one() throws Exception
    {
        // given
        List<MaterialSupplyDetail> materialSupplyDetails = newArrayList(ImmutableList.<MaterialSupplyDetail>builder().add(CAPACITY).add(RAW_ROSE_005_ONE).build());
        // when
        int amount = product98100201.calculateSupplyAmount(new CombinedMaterials(materialSupplyDetails));
        // then
        assertThat(amount, is(1));
    }

    @Test
    public void should_caculate_beginning_supply_date_for_98100201_case_two() throws Exception
    {
        // given
        List<MaterialSupplyDetail> materialSupplyDetails = newArrayList(ImmutableList.<MaterialSupplyDetail>builder().add(CAPACITY).add(RAW_ROSE_005_TWO).build());
        // when
        String result = product98100201.calculateBeginningDate(new CombinedMaterials(materialSupplyDetails));
        // then
        assertThat(result, is("2015-01-01 00:00:00"));
    }


    @Test
    public void should_caculate_end_supply_date_for_98100201_case_two() throws Exception
    {
        // given
        List<MaterialSupplyDetail> materialSupplyDetails = newArrayList(ImmutableList.<MaterialSupplyDetail>builder().add(CAPACITY).add(RAW_ROSE_005_TWO).build());
        // when
        String result = product98100201.calculateEndDate(new CombinedMaterials(materialSupplyDetails));
        // then
        assertThat(result, is("2015-01-15 00:00:00"));
    }

    @Test
    public void should_caculate_supply_amount_for_98100201_case_two() throws Exception
    {
        // given
        List<MaterialSupplyDetail> materialSupplyDetails = newArrayList(ImmutableList.<MaterialSupplyDetail>builder().add(CAPACITY).add(RAW_ROSE_005_TWO).build());
        // when
        int amount = product98100201.calculateSupplyAmount(new CombinedMaterials(materialSupplyDetails));
        // then
        assertThat(amount, is(47));
    }


    @Test
    public void should_caculate_supply_amount_for_98102601_case_one() throws Exception
    {
        // given
        List<MaterialSupplyDetail> materialSupplyDetails = newArrayList(ImmutableList.<MaterialSupplyDetail>builder().add(RAW_EUCALYPTUS_001_ONE).add(RAW_ROSE_005_ONE).add(CAPACITY).build());
        // when
        int amount = product98102601.calculateSupplyAmount(new CombinedMaterials(materialSupplyDetails));
        // then
        assertThat(amount, is(1));
    }


    @Test
    public void should_caculate_beginning_date_for_98102601_case_one() throws Exception
    {
        // given
        List<MaterialSupplyDetail> materialSupplyDetails = newArrayList(ImmutableList.<MaterialSupplyDetail>builder().add(RAW_EUCALYPTUS_001_ONE).add
                (RAW_ROSE_005_ONE).add(CAPACITY).build());
        // when
        String result = product98102601.calculateBeginningDate(new CombinedMaterials(materialSupplyDetails));
        // then
        assertThat(result, is("2014-10-01 00:00:00"));
    }


    @Test
    public void should_caculate_end_date_for_98102601_case_one() throws Exception
    {
        // given
        List<MaterialSupplyDetail> materialSupplyDetails = newArrayList(ImmutableList.<MaterialSupplyDetail>builder().add(RAW_EUCALYPTUS_001_ONE).add
                (RAW_ROSE_005_ONE).add(CAPACITY).build());
        // when
        String result = product98102601.calculateEndDate(new CombinedMaterials(materialSupplyDetails));
        // then
        assertThat(result, is("2014-10-31 00:00:00"));
    }


    @Test(expected = InvalidTimeWindowException.class)
    public void should_caculate_supply_amount_for_98102601_case_two() throws Exception
    {
        // given
        List<MaterialSupplyDetail> materialSupplyDetails = newArrayList(ImmutableList.<MaterialSupplyDetail>builder().add(RAW_EUCALYPTUS_001_ONE).add
                (RAW_ROSE_005_TWO).add(CAPACITY).build());
        // when
        product98102601.calculateSupplyAmount(new CombinedMaterials(materialSupplyDetails));
    }


    @Test(expected = InvalidTimeWindowException.class)
    public void should_caculate_supply_amount_for_98102601_case_three() throws Exception
    {
        // given
        List<MaterialSupplyDetail> materialSupplyDetails = newArrayList(ImmutableList.<MaterialSupplyDetail>builder().add(RAW_EUCALYPTUS_001_TWO).add
                (RAW_ROSE_005_TWO).add(CAPACITY).build());
        // when
        product98102601.calculateSupplyAmount(new CombinedMaterials(materialSupplyDetails));
    }

    @Test(expected = InvalidTimeWindowException.class)
    public void should_caculate_supply_amount_for_98102601_case_four() throws Exception
    {
        // given
        List<MaterialSupplyDetail> materialSupplyDetails = newArrayList(ImmutableList.<MaterialSupplyDetail>builder().add(RAW_EUCALYPTUS_001_TWO).add
                (RAW_ROSE_005_TWO).add(CAPACITY).build());
        // when
        product98102601.calculateSupplyAmount(new CombinedMaterials(materialSupplyDetails));
    }


    @Test
    public void should_get_list_of_possible_combination_of_materials_for_98100201() throws Exception
    {
        // when
        List<CombinedMaterials> result = product98100201.getPossibleCombinationOfMaterials();
        // then
        Assert.assertThat(result.size(), is(2));
    }

    @Test
    public void should_get_list_of_possible_combination_of_materials_for_98102601() throws Exception
    {
        // when
        List<CombinedMaterials> result = product98102601.getPossibleCombinationOfMaterials();
        // then
        Assert.assertThat(result.size(), is(4));
    }




}
