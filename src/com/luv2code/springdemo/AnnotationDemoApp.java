package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		//read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
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
