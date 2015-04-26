package com.symbio.supplier.domains;

import com.symbio.supplier.comparators.StartDateComparator;
import com.symbio.supplier.comparators.EndDateComparator;
import com.symbio.supplier.utils.DateUtils;
import com.symbio.supplier.exceptions.InvalidTimeWindowException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Product
{
    private final String name;
    private final List<Material> materials;

    public Product(String name, List<Material> materials)
    {
        this.name = name;
        this.materials = materials;
    }

    public String calculateBeginningDate(CombinedMaterials combinedMaterials)
    {

        Collections.sort(combinedMaterials.getMaterialSupplyDetails(), new StartDateComparator());
        return combinedMaterials.getMaterialSupplyDetails().get(0).getStartDate();
    }

    public String calculateEndDate(CombinedMaterials combinedMaterials)
    {
        Collections.sort(combinedMaterials.getMaterialSupplyDetails(), new EndDateComparator());
        return combinedMaterials.getMaterialSupplyDetails().get(0).getEndDate();
    }

    public int calculateSupplyAmount(CombinedMaterials combinedMaterials)
    {
        checkValidTimeWindow(combinedMaterials);
        List<Integer> amountList = new ArrayList<Integer>();
        for (Material material : materials) {
            for (MaterialSupplyDetail materialSupplyDetail : combinedMaterials.getMaterialSupplyDetails()) {
                if (material.getMaterialCategory().hasContains(materialSupplyDetail)) {
                    amountList.add(materialSupplyDetail.getAmount() / material.getAmount());
                }
            }
        }
        Collections.sort(amountList);
        return amountList.get(0);
    }

    private void checkValidTimeWindow(CombinedMaterials combinedMaterials)
    {
        Date beginingDate = DateUtils.strToDate(calculateBeginningDate(combinedMaterials));
        Date endDate = DateUtils.strToDate(calculateEndDate(combinedMaterials));

        if(beginingDate.after(endDate)){
            throw new InvalidTimeWindowException();
        }
    }

    public String getName()
    {
        return name;
    }

    public List<CombinedMaterials> getPossibleCombinationOfMaterials()
    {

        int total = 1;

        for(int i = 0; i < materials.size(); i++){
            total *= materials.get(i).getMaterialSupplyDetails().size();
        }

        CombinedMaterials[] result = new CombinedMaterials[total];

        int current = 1;
        int loopNumPerMaterialDetails;
        int loopNumPerMaterialCategory;
        for (int i = 0; i < materials.size(); i++){
            List<MaterialSupplyDetail> currentMaterialSupplyDetails = materials.get(i).getMaterialSupplyDetails();
            current = current * currentMaterialSupplyDetails.size();

            int index = 0;
            int currentSize = currentMaterialSupplyDetails.size();
            loopNumPerMaterialDetails = total / current;
            loopNumPerMaterialCategory = total / (loopNumPerMaterialDetails * currentSize);
            int currentIndex = 0;

            for (int j = 0; j < currentMaterialSupplyDetails.size(); j++){
                for (int k = 0; k < loopNumPerMaterialCategory; k++){
                    if (currentIndex == currentMaterialSupplyDetails.size()){
                        currentIndex = 0;
                    }
                    for (int m = 0; m < loopNumPerMaterialDetails; m++){
                        if (result[index] == null){
                            result[index] = new CombinedMaterials(new ArrayList<MaterialSupplyDetail>());
                        }
                        result[index] = result[index].add(currentMaterialSupplyDetails.get(currentIndex));
                        index++;
                    }
                    currentIndex++;
                }

            }
        }


        return Arrays.asList(result);
    }
}
