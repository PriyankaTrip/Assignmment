package com.espring.assignment.Assg1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Supply {
    private String productId;
    private String updateTimeStamp;
    private double quantity;
}
