package com.espring.assignment.Assg1.Service;

import com.espring.assignment.Assg1.Model.Supply;
import com.espring.assignment.Assg1.Model.SupplyOutput;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SupplyService {

    private static List<Supply> supplyList = new ArrayList<>();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss.SSS'Z'");

    public List<Supply> getSupplyList() throws ParseException {

        Date date1 = formatter.parse("2021-03-16T08:53:48.616Z");
        Date date2 = formatter.parse("2021-03-16T08:59:48.616Z");
        Date date3 = formatter.parse("2021-03-16T09:10:48.616Z");
        Date date4 = formatter.parse("2021-03-16T09:10:48.616Z");
        supplyList.add(new Supply("Product1", formatter.format(date1), 10));
        supplyList.add(new Supply("Product2", formatter.format(date2), 5));
        supplyList.add(new Supply("Product3", formatter.format(date3), 30));
        supplyList.add(new Supply("Product4", formatter.format(date4), 20));
        return supplyList;
    }

    public SupplyOutput getSupplyStatus(Supply supply) {

        Double quantity = supplyList.stream().filter(s -> s.getProductId().equals((supply.getProductId())))
                .filter(s -> s.getUpdateTimeStamp().compareTo(supply.getUpdateTimeStamp()) < 0 )
                .mapToDouble(s -> s.getQuantity()).sum();

        SupplyOutput supplyOutput = null;
        if (quantity > 0) {
            quantity = quantity + supply.getQuantity();
            supplyOutput = new SupplyOutput(supply.getProductId(), supply.getUpdateTimeStamp(), quantity, "Updated");
        }
        else
            supplyOutput = new SupplyOutput(supply.getProductId(), supply.getUpdateTimeStamp(), supply.getQuantity(), "Out of sync update");

        return supplyOutput;

    }
}
