package com.example.springcoredemo.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In constructor: " +getClass().getSimpleName());
    }
    /*

    //Define init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In my doMyStartupStuff(): " +getClass().getSimpleName());
    }

    //Define destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In my doMyCleanupStuff(): " +getClass().getSimpleName());
    }
*/


    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
