package com.symbio.supplier.services;

import com.symbio.supplier.domains.CombinedMaterials;
import com.symbio.supplier.domains.Product;
import com.symbio.supplier.views.ProductSupplyInfo;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService
{
    private Product product;

    public ProductServiceImpl(Product product)
    {
        this.product = product;
    }

    @Override
    public List<ProductSupplyInfo> getProductSupplyInfos()
    {
        List<ProductSupplyInfo> productSupplyInfos = new ArrayList<ProductSupplyInfo>();
        for (CombinedMaterials possibleCombinationOfMaterials : getPossibleCombinationOfMaterials()) {
            addProductSupplyInfoIntoList(productSupplyInfos, possibleCombinationOfMaterials);
        }

        return productSupplyInfos;
    }

    private void addProductSupplyInfoIntoList(List<ProductSupplyInfo> productSupplyInfos, CombinedMaterials possibleCombinationOfMaterials)
    {
        try {
            productSupplyInfos.add(new ProductSupplyInfo(product.getName(), product.calculateStartDate(possibleCombinationOfMaterials),
                    product.calculateEndDate(possibleCombinationOfMaterials), product.calculateSupplyAmount(possibleCombinationOfMaterials)));
        } catch (Exception e) {
            //TODO: will use logger and this exception will also been handled by global handler in future
            e.printStackTrace();
        }

    }

    private List<CombinedMaterials> getPossibleCombinationOfMaterials()
    {
        return product.getPossibleCombinationOfMaterials();
    }
}
