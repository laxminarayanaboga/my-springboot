package com.example.demo.common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor -- " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "From SwimCoach -- practice running for sometime";
    }
}
