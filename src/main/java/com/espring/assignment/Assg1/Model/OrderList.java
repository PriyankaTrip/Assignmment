package com.espring.assignment.Assg1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class OrderList {
    private String orderId;
    private String createDate;
    private double quantity;

}
