package com.symbio.supplier.comparators;

import com.symbio.supplier.Domain.MaterialDetail;

import java.util.Date;

import static com.symbio.supplier.Utils.DateUtils.strToDate;

public class BeginningDateComparator implements java.util.Comparator<MaterialDetail>
{
    @Override
    public int compare(MaterialDetail materialDetail1, MaterialDetail materialDetail2)
    {
        Date date1 = strToDate(materialDetail1.getStartDate());
        Date date2 = strToDate(materialDetail2.getStartDate());

        if (date1.after(date2)) {
            return -1;
        } else if (date1.before(date2)) {
            return 1;
        } else {
            return 0;
        }

    }
}
