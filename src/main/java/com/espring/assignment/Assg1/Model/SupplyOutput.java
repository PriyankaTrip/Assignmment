package com.espring.assignment.Assg1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SupplyOutput {
    private String productId;
    private String updateTimeStamp;
    private double quantity;
    private String status;
}
