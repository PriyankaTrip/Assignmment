package com.espring.assignment.Assg1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    public String productId;
    public String prodName;
    public String UOM;
    public Double availQty;
    public String availDate;

}

