package com.symbio.supplier.comparators;

import com.symbio.supplier.domains.MaterialSupplyDetail;

import java.util.Date;

import static com.symbio.supplier.utils.DateUtils.strToDate;

public class EndDateComparator implements java.util.Comparator<MaterialSupplyDetail>
{
    @Override
    public int compare(MaterialSupplyDetail materialSupplyDetail1, MaterialSupplyDetail materialSupplyDetail2)
    {
        Date date1 = strToDate(materialSupplyDetail1.getEndDate());
        Date date2 = strToDate(materialSupplyDetail2.getEndDate());

        if (date1.after(date2)) {
            return 1;
        } else if (date1.before(date2)) {
            return -1;
        } else {
            return 0;
        }
    }
}
