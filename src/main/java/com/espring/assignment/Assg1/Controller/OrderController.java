package com.espring.assignment.Assg1.Controller;

import com.espring.assignment.Assg1.Model.Order;
import com.espring.assignment.Assg1.Model.OrderInput;
import com.espring.assignment.Assg1.Model.OrderOutput;
import com.espring.assignment.Assg1.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    public OrderService orderService;
    public Order order;
   /* @GetMapping("/getlist")
    public List<Order> getList()
    {
        return orderService.getOrderList();
    }*/

    @PostMapping("/getOrderStats")
    public OrderOutput getStatus(@RequestBody OrderInput orderInput) {
        orderService.getOrderList();
        return orderService.getOrderStats(orderInput.getStatName());
    }

}
