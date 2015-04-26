package com.symbio.supplier.services;

import com.symbio.supplier.domains.ProductTest;
import com.symbio.supplier.views.ProductSupplyInfo;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProductServiceImplTest extends ProductTest
{

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