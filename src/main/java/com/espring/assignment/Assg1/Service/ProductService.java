package com.espring.assignment.Assg1.Service;

import com.espring.assignment.Assg1.Model.InputProduct;
import com.espring.assignment.Assg1.Model.Product;

import java.util.List;

/***
 * Interface of product class for getting Inventory details
 * as Product Id, Name, UOM, Available Quantity, Available Date
 */
public interface ProductService {

    public Double getInventoryPicture(InputProduct inputProduct);

    public List<Product> getProduct();



}
