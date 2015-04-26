package com.symbio.supplier.domains;

import com.symbio.supplier.comparators.BeginningDateComparator;
import com.symbio.supplier.comparators.EndDateComparator;
import com.symbio.supplier.Utils.DateUtils;
import com.symbio.supplier.exceptions.InvalidTimeWindowException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Product
{
    private final String name;
    private final List<Material> materials;

    public Product(String name, List<Material> materials)
    {
        this.name = name;
        this.materials = materials;
    }

    public String caculateBeginningDate(List<MaterialDetail> materialDetails)
    {
        Collections.sort(materialDetails, new BeginningDateComparator());
        return materialDetails.get(0).getStartDate();
    }

    public String caculateEndDate(List<MaterialDetail> materialDetails)
    {
        Collections.sort(materialDetails, new EndDateComparator());
        return materialDetails.get(0).getEndDate();
    }

    public int caculateSupplyAmount(List<MaterialDetail> materialDetails)
    {
        checkValidTimeWindow(materialDetails);
        List<Integer> amountList = new ArrayList<>();
        for (Material material : materials) {
            for (MaterialDetail materialDetail : materialDetails) {
                if (material.getMaterialCategory().hasContains(materialDetail)) {
                    amountList.add(materialDetail.getAmount() / material.getAmount());
                }
            }
        }
        Collections.sort(amountList);
        return amountList.get(0);
    }

    private void checkValidTimeWindow(List<MaterialDetail> materialDetails)
    {
        Date beginingDate = DateUtils.strToDate(caculateBeginningDate(materialDetails));
        Date endDate = DateUtils.strToDate(caculateEndDate(materialDetails));

        if(beginingDate.after(endDate)){
            throw new InvalidTimeWindowException();
        }
    }
}
