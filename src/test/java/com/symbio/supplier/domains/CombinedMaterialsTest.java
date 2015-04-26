package com.symbio.supplier.domains;

import com.symbio.supplier.exceptions.IllegalCombinatedMaterialsException;
import org.junit.Test;

import java.util.ArrayList;

public class CombinedMaterialsTest
{
    @Test(expected = IllegalCombinatedMaterialsException.class)
    public void should_throw_exception_when_inputed_combinated_materials_is_empty() throws Exception
    {
        // given
        CombinedMaterials combinedMaterials = new CombinedMaterials(new ArrayList<MaterialDetail>());
        // when
        combinedMaterials.getMaterialDetails();
    }

    @Test(expected = IllegalCombinatedMaterialsException.class)
    public void should_throw_exception_when_inputed_combinated_materials_is_null() throws Exception
    {
        // given
        CombinedMaterials combinedMaterials = new CombinedMaterials(null);
        // when
        combinedMaterials.getMaterialDetails();
    }
}