package com.example.demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In constructor -- " + getClass().getSimpleName());
    }

    @PostConstruct
    public void doSomeStuffAfterStartUp(){
        System.out.println("@PostConstruct -- In doSomeStuffAfterStartUp -- ");
    }

    @PreDestroy
    public void doSomeStuffBeforeClosing(){
        System.out.println("@PreDestroy -- In doSomeStuffBeforeClosing -- ");
    }

    @Override
    public String getDailyWorkout() {
        return "From cricketCoach -- Practice fast bowling for 15 minutes;";
    }
}
