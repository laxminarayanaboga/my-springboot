package com.example.demo.rest;

import com.example.demo.common.Coach;
import com.example.demo.common.CricketCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // == Dependency Injection -- Field Injection ==
//    @Autowired
//    public CricketCoach myCoach;

    // == Dependency Injection -- Constructor Injection ==
    private Coach myCoach;
    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach) {
        this.myCoach = theCoach;
    }

    // == Dependency Injection -- Setter Injection ==
//    private Coach myCoach;
//    @Autowired
//    public void setCoach(Coach theCoach) {
//        this.myCoach = theCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
