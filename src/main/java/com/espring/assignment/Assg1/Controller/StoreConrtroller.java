package com.espring.assignment.Assg1.Controller;

import com.espring.assignment.Assg1.Model.*;
import com.espring.assignment.Assg1.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class StoreConrtroller {

    @Autowired
    private StoreService storeService;

  /*  @GetMapping("/getAvailability")
    public List<Availability> getAvailability(){
        return storeService.getAvailabilityList();
    }

    @GetMapping("/getCapacity")
    public List<Capacity> getCapacity(){
        return storeService.getCapacityList();
    }
   */


    @PostMapping("/getProdAvailability")
    public ResponseEntity<StoreOutput> getProductAvailability(@RequestBody StoreInput storeInput){
        storeService.getAvailabilityList();
        storeService.getCapacityList();
       /* CompletableFuture<Availability> storeAvailability = storeService.getAvailabilty(storeInput.getStoreNo());
        CompletableFuture<Capacity> storeCapacity= storeService.getCapacity(storeInput.getStoreNo());
        CompletableFuture.allOf(storeAvailability,storeCapacity).join();
        */
        String status = storeService.getStatus(storeInput.getReqDate());
        if(status.equals("No Capacity") || status.equals("No Availability") || status.equals("Available")){
            StoreOutput storeOutput = new StoreOutput(storeInput,status);
            return new ResponseEntity<StoreOutput>(storeOutput, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
