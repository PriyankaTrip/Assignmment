package com.espring.assignment.Assg1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Order {

    private String orderId;
    private String productId;
    private String createDate;
    private double quantity;
}
