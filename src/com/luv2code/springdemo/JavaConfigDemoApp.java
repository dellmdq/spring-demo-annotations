package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		//read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		//get bean from container
		
		//Coach theCoach = context.getBean("thatSillyCoach", Coach.class);//using specfic bean		

		//using default bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		//call methods
		System.out.println(theCoach.getDailyWorkout());
				
		//call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//close container
		context.close();
	}

}
