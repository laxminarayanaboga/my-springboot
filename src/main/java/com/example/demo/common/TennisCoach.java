package com.example.demo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("In constructor -- " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "From Tennins Coach -- practice running for 15 min";
    }
}
