package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define private field for the dependency
    private Coach myCoach;



    //Construction Injection
    //define constructor for dependency injection
    /*@Autowired
    public DemoController(Coach theCoach){
        myCoach=theCoach;
    }
     */


    //Setter Injection
    /*@Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }
     */



    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach) {
        System.out.println("In constructor: " +getClass().getSimpleName());
        myCoach=theCoach;

    }



    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }



}
