package com.espring.assignment.Assg1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Availability {
    private String storeNo;
    private String productId;
    private String date;
    private double availQty;
}
