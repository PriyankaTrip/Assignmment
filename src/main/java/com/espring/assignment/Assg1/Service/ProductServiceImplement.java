package com.espring.assignment.Assg1.Service;

import com.espring.assignment.Assg1.Model.InputProduct;
import com.espring.assignment.Assg1.Model.Product;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImplement implements ProductService {

    private static List<Product> inventoryList = new ArrayList<>();
    private static List<Product> inputList = new ArrayList<>();

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

    @Override
    public List<Product> getProduct() {

        Date avldate, avldate1, avldate2;
        try {
            avldate = formatter.parse("2021-03-19");
            avldate1 = formatter.parse("2021-03-21");
            avldate2 = formatter.parse("2021-03-29");

            Product inventory = new Product("Prod1", "Shirt", "EACH", 10.0, formatter.format(avldate));
            inventoryList.add(inventory);
            Product inventory1 = new Product("Prod1", "Trousers", "EACH", 20.0, formatter.format(avldate1));
            inventoryList.add(inventory1);
            Product inventory2 = new Product("Prod1", "Trousers", "EACH", 20.0, formatter.format(avldate2));
            inventoryList.add(inventory2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return inventoryList;
    }

    //Product product = new Product();

    @Override
    public Double getInventoryPicture(InputProduct inputProduct) {

        LocalDate Date1 = LocalDate.parse(inputProduct.getAvailDate());
        LocalDate Date2 = Date1.plusDays(10);
        double quantity = 0;

        if (Date1.isAfter(LocalDate.of(2021, 03, 18)) && Date1.isBefore(LocalDate.of(2021, 03, 30))) {
            for (Product i : inventoryList) {
                LocalDate Date3 = LocalDate.parse(i.getAvailDate());
                if (Date3.isAfter(Date1.minusDays(1)) && Date3.isBefore(Date2.plusDays(1))) {
                    quantity = quantity + i.getAvailQty();
                }
            }
            return quantity;
        } else
            return quantity;
    }

}

        /*Date date,date1;
        try {
            date = formatter.parse(inputProduct.getAvailDate());
            date1 = formatter.parse(product.getAvailDate());
            //List<Product> product1 = inventoryList.stream().filter(p->p.getAvailDate().compareTo(formatter1.format(date)));
            //for(int i=0; formatter.parse(product.getAvailDate()).compareTo(formatter1.parse(inputProduct.getAvailDate())); )

                Date d1 = (date,date1) ->formatter.format(date).compareTo(formatter.format(date1));

        }catch (ParseException e) {
            e.printStackTrace();
        }*/

  /*  public String getDate(String date) {

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-mm-dd");

        Date avldate;
        try {
            avldate = formatter.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Date"+ date);
        return null;
    }*/

  /*public Double  (Product product){
        inputList.add(product);
        Date date = new SimpleDateFormat("yyyy-mm-dd");
        List<Product> product1 = (List<Product>) inventoryList.stream().filter(p->p.getavailDate().equals(product));
        return product1;
    }*/

