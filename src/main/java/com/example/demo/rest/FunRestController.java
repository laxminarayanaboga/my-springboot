package com.example.demo.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${demo.name}")
    private String demoName;

    @Value("${team.name}")
    private String teamName;

    @Value("${coach.name}")
    private String coachName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! say.. " + demoName;
    }

    @GetMapping("/getExample1")
    public String getExample1() {
        return "This is getExample1";
    }

    @GetMapping("/teamInfo")
    public String teamInfo() {
        return "coachName: " + coachName + ", teamName: " + teamName;
    }
}
