package com.luv2code.springdemo;


import org.springframework.beans.factory.annotation.Value;

public class PaddleCoach implements Coach {

    @Value("${paddle.name}")
    private String name;

    @Value("${paddle.email}")
    private String email;

    @Value("${paddle.age}")
    private Integer age;

    private FortuneService fortuneService;

    public PaddleCoach(FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "I want you to practice deep shots";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }
}
