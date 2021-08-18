package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		//read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		//get bean from container
		
		//Coach theCoach = context.getBean("thatSillyCoach", Coach.class);//using specfic bean		

		//using default bean
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//call methods
		System.out.println(theCoach.getDailyWorkout());
				
		//call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());

		//call our new swim coach methods.. has the props values injected
		System.out.println("Email: " + theCoach.getEmail());
		System.out.println("Team: " + theCoach.getTeam());

		//close container
		context.close();
	}

}
