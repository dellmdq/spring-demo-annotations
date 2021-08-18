package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component//("thatSillyCoach") to use default bean //so spring detect this class when component scanning starts. and then asigns the bean to this class.
@Scope("singleton")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("fileFortuneService")//with @Qualifier you select which implementation of the Fortune Service interface
	//to use with your TennisCoach instance.
	private FortuneService fortuneService;
	 
	
	//define default constructor (no-arg) just to know when spring is inside it
	public TennisCoach() {
		System.out.println("TennisCoach: inside default constructor");
	}

	//define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of myDoStartupStuff()");
	}

	//define my destroy method
	@PreDestroy
	public void doMyCleanupStuff(){
		System.out.println(">> TennisCoach: inside of my doMyCleanupStuff()");
	}


	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	*/

	//define setter method
	/*
	@Autowired//spring will resolve the dependency looking for the FortuneService implementation
	public void setFortuneService(FortuneService thefortuneService) {
		System.out.println("TennisCoach: inside setFortuneService() method");
		this.fortuneService = thefortuneService;
	}
	*/

	//@Autowired//custom setter method. testing dependency injection.
	//you can use any method name with autowired to inject dependencies
	/*public void doCrazyStuff(FortuneService thefortuneService) {
		System.out.println("TennisCoach: inside doSomeCrazyStuff() method");
		this.fortuneService = thefortuneService;
	}*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
