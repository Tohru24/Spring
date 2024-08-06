package com.luv2code.Springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("In constructor:" + getClass().getSimpleName());
    }
    @PostConstruct
    public void doStartStuff() {
        System.out.println("In postConstruct:" + getClass().getSimpleName());
    }

    @PreDestroy
    public void doStopStuff() {
        System.out.println("In preDestroy:" + getClass().getSimpleName());
    }




    @Override
    public String getDailyWorkOut() {

        return "Practice fast bowling for 15 minutes";
    }
}
