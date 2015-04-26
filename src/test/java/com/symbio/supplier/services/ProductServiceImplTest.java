package com.symbio.supplier.services;

import com.google.common.collect.ImmutableList;
import com.symbio.supplier.domains.Material;
import com.symbio.supplier.domains.MaterialCategory;
import com.symbio.supplier.domains.Product;
import com.symbio.supplier.views.ProductSupplyInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProductServiceImplTest
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
    public void should_get_list_of_product_supply_info_object_for_98100201() throws Exception
    {
        // given
        ProductServiceImpl productService = new ProductServiceImpl(product98100201);
        // when
        List<ProductSupplyInfo> result = productService.getProductSupplyInfos();
        // then
        assertThat(result.size(), is(2));
    }


    @Test
    public void should_get_list_of_product_supply_info_object_for_98102601() throws Exception
    {
        // given
        ProductServiceImpl productService = new ProductServiceImpl(product98102601);
        // when
        List<ProductSupplyInfo> result = productService.getProductSupplyInfos();
        // then
        assertThat(result.size(), is(1));
    }

}