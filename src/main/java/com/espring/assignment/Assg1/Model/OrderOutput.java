package com.espring.assignment.Assg1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class OrderOutput {
    private String productId;
    private List<OrderList> orderList;
}
