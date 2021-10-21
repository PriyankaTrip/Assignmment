package com.espring.assignment.Assg1.Service;

import com.espring.assignment.Assg1.Model.Order;
import com.espring.assignment.Assg1.Model.OrderList;
import com.espring.assignment.Assg1.Model.OrderOutput;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class OrderService {
    private static List<Order> orderList = new ArrayList<>();

    /*public  List<Order> getOrderList() {
        Order order1 = new Order ("Order1","Product1","2021-03-16",10.0);
        Order order2 = new Order ("Order2", "Product2","2021-03-19",5.0);
        Order order3 = new Order ("Order3", "Product1","2021-03-16",30.0);
        Order order4 = new Order ("Order4", "Product4","2021-03-20",20.0);
        Order order5 = new Order ("Order5", "Product2","2021-03-16",20.0);
        return orderList;
    }*/
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

    public List<Order> getOrderList() {
        Date date1, date2, date3, date4, date5;
        try {
            date1 = formatter.parse("2021-03-16");
            date2 = formatter.parse("2021-03-19");
            date3 = formatter.parse("2021-03-16");
            date4 = formatter.parse("2021-03-20");
            date5 = formatter.parse("2021-03-16");
            orderList.add(new Order("Order1", "Product1", formatter.format(date1), 10));
            orderList.add(new Order("Order2", "Product2", formatter.format(date2), 5));
            orderList.add(new Order("Order3", "Product1", formatter.format(date3), 30));
            orderList.add(new Order("Order4", "Product4", formatter.format(date4), 20));
            orderList.add(new Order("Order5", "Product2", formatter.format(date5), 20));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public OrderOutput getOrderStats(String status) {
        //OrderService service = new OrderService();
        //Map<String, Double> map = new HashMap<String, Double>();

        //Adding the quantities of each product available in the list
        Double quantity1 = 0.0, quantity2 = 0.0, quantity3 = 0.0;
        for (Order o : orderList) {
            if (o.getProductId().equals("Product1")) {
                quantity1 += o.getQuantity();
            } else if (o.getProductId().equals("Product2")) {
                quantity2 += o.getQuantity();
            } else if (o.getProductId().equals("Product4")) {
                quantity3 += o.getQuantity();
            }
        }
       /* map.put("Product1", new Double(quantity1));
        map.put("Product2", new Double(quantity2));
        map.put("Product4", new Double(quantity3));
        */

        //getting Maximum and minimum quanty by checking the status
        List<Double> l = Arrays.asList(quantity1, quantity2, quantity3);
        Double maximum = 0.0;
        Double minimum = 0.0;
        if (status.equals("MAX_SALE")) {
            maximum = l.stream().max(Double::compare).get();
        } else {
            minimum = l.stream().min(Double::compare).get();
        }

        //checking which quantity has maximum or minimum value and then check which ProductID
        // has maximum or minimum value and then pass it to output
        OrderOutput orderOutput = null;
        List<OrderList> orderCombinedList = new ArrayList<>();
        if (maximum.equals(quantity1)) {
            for(Order o:orderList) {
                if(o.getProductId().equalsIgnoreCase("Product1")) {
                    OrderList collectOrderList = new OrderList(o.getOrderId(), o.getCreateDate(), o.getQuantity());
                    orderCombinedList.add(collectOrderList);
                        orderOutput = new OrderOutput("Product1", orderCombinedList);
                }
            }
        }
        if (minimum.equals(quantity3)) {
            for(Order o:orderList) {
                if(o.getProductId().equalsIgnoreCase("Product4")) {
                    OrderList collectOrderList = new OrderList(o.getOrderId(), o.getCreateDate(), o.getQuantity());
                        orderCombinedList.add(collectOrderList);
                    orderOutput = new OrderOutput("Product4", orderCombinedList);
                }
            }
        }
       // System.out.println(orderOutput);
        return orderOutput;
    }
}
