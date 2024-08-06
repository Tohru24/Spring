package com.luv2code.Springcoredemo.common;

public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("in Constructor: " + getClass().getName());
    }
    @Override
    public String getDailyWorkOut() {
        return "Swim 1000 meters as a warm up";
    }
}
