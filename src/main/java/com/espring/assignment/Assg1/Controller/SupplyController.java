package com.espring.assignment.Assg1.Controller;

import com.espring.assignment.Assg1.Model.Supply;
import com.espring.assignment.Assg1.Model.SupplyOutput;
import com.espring.assignment.Assg1.Service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class SupplyController {
    @Autowired
    public SupplyService supplyService;

    @GetMapping("/supplyList")
        public List<Supply> getsupplylist() throws ParseException {
        return supplyService.getSupplyList();
    }

    @PostMapping("/updateSupply")
        public SupplyOutput getStaus(@RequestBody Supply supply) throws ParseException {
        supplyService.getSupplyList();
        return supplyService.getSupplyStatus(supply);
    }

}
