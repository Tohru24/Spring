package com.luv2code.Springcoredemo.rest;

import com.luv2code.Springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach mycoach;
    private Coach anotherCoach;
    
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach,
                          @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("In constructor:" + getClass().getSimpleName());
        mycoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return mycoach.getDailyWorkOut();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: mycoach == anotherCoach, " + (mycoach==anotherCoach);
    }
}
