package com.espring.assignment.Assg1.Controller;

import com.espring.assignment.Assg1.Model.InputProduct;
import com.espring.assignment.Assg1.Model.OutputProduct;
import com.espring.assignment.Assg1.Model.Product;
import com.espring.assignment.Assg1.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    List<Product> productList;
    //List<OutputProduct> outputProducts;

   /* @GetMapping("/product")
    public List<Product> productDetails() {
        productList = productService.getProduct();
        return productList;
    }*/

    @PostMapping("/getInvPicture")
    public ResponseEntity<OutputProduct> getInventoryPicture(@RequestBody InputProduct inputProduct){
        productService.getProduct();
        OutputProduct outputProduct=null;
        double avlquantity = productService.getInventoryPicture(inputProduct);
        //outputProduct.setAvailQty(ans);
        if(avlquantity !=0){
            outputProduct = new OutputProduct(inputProduct.getProductId(),inputProduct.getProdName(),avlquantity);
            return new ResponseEntity<>(outputProduct, HttpStatus.OK);
        }
        return new ResponseEntity<OutputProduct>(HttpStatus.BAD_REQUEST);

    }


}
