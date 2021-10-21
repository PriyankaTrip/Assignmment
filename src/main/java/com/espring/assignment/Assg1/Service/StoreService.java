package com.espring.assignment.Assg1.Service;

import com.espring.assignment.Assg1.Model.Availability;
import com.espring.assignment.Assg1.Model.Capacity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class StoreService{

    private static List<Capacity> capacityList = new ArrayList<>();
    private static List<Availability> availabilityList = new ArrayList<>();

    /***
     * getting the Capacity List and Availability List
     */
    public void getAvailabilityList(){
        availabilityList.add(new Availability("Store001", "Prod1", "2021-02-19", 0));
        availabilityList.add(new Availability("Store001", "Prod2", "2021-02-20", 3.0));
        availabilityList.add(new Availability("Store001", "Prod2", "2021-02-21",0));
    }
    public void getCapacityList()  {
        capacityList.add(new Capacity("Store001", "Prod1", "2021-02-19", 0));
        capacityList.add(new Capacity("Store001", "Prod1", "2021-02-20", 2.0));
        capacityList.add(new Capacity("Store001", "Prod1", "2021-02-21", 2.0));
        capacityList.add(new Capacity("Store001", "Prod1", "2021-02-22", 0));
    }

    /***
     * Getting the stats of availability and capacity on the requested date
     * compares the requested date with the dates in the list get the available quantity on that reqDate
     * @param reqDate the date requested at the input
     * @return the string stats of specified scenario
     */
    public String getStatus(String reqDate){
        double availability = 0;
        availability = availabilityList.stream().filter(i -> i.getDate().equals(reqDate)).mapToDouble(i -> i.getAvailQty()).sum();
        double capacity = 0;
        capacity = capacityList.stream().filter(i -> i.getDate().equals(reqDate)).mapToDouble(i -> i.getNoOfOrdersAccepted()).sum();
        if(availability == 0 && capacity ==0)
            return "No Content";
        else if(capacity ==0)            //availability>0 && capacity==0
            return "No Capacity";
        else if(availability==0)        //availability==0 && capacity>0
            return "No Availability";
        else                           //availability>0 && capacity>0
            return "Available";
    }

}



/*public void getCapacityList() {
            Capacity capacity1 = new Capacity(" Store001", "Prod1", new Date(2021-02-19), 0);
            Capacity capacity2 = new Capacity(" Store001", "Prod1", new Date(2021-02-20), 2.0);
            Capacity capacity3 = new Capacity(" Store001", "Prod1", new Date(2021-02-21), 2.0);
            Capacity capacity4 = new Capacity(" Store001", "Prod1", new Date(2021-02-22), 0);
            //return capacityList;
        }
        public void getAvailabilityList(){
            Availability availability1 = new Availability("Store001", "Prod1", new Date(2021-02-19), 1.0);
            Availability availability2 = new Availability("Store001", "Prod1", new Date(2021-02-20), 3.0);
            Availability availability3 = new Availability("Store001", "Prod1", new Date(2021-02-21), 0.0);
            //return availabilityList;
        }

     */
/* SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
       public void getCapacityList() {
           Date date1, date2, date3, date4;
           try {
               date1 = formatter.parse("2021-02-19");
               date2 = formatter.parse("2021-02-20");
               date3 = formatter.parse("2021-02-21");
               date4 = formatter.parse("2021-02-22");
               capacityList.add(new Capacity(" Store001", "Prod1", formatter.format(date1), 0));
               capacityList.add(new Capacity(" Store001", "Prod1", formatter.format(date2), 2.0));
               capacityList.add(new Capacity(" Store001", "Prod1", formatter.format(date3), 2.0));
               capacityList.add(new Capacity(" Store001", "Prod1", formatter.format(date4), 0));
           } catch (ParseException e) {
               e.printStackTrace();
           }
           //return capacityList;
       }
    public void getAvailabilityList(){
        Date date1, date2, date3;
        try {
            date1 = formatter.parse("2021-02-19");
            date2 = formatter.parse("2021-02-20");
            date3 = formatter.parse("2021-02-21");
            availabilityList.add(new Availability("Store001", "Prod1", formatter.format(date1), 1.0));
            availabilityList.add(new Availability("Store001", "Prod2", formatter.format(date2), 3.0));
            availabilityList.add(new Availability("Store001", "Prod2", formatter.format(date3), 0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
       // return availabilityList;
    }

      */

