package com.espring.assignment.Assg1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Capacity {
    private String storeNo;
    private String productId;
    private String date;
    private double noOfOrdersAccepted;

}
