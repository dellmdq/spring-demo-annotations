package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
	
	public static void main(String[] args) {
		
		//load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get bean from the spring container
		Coach theCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		//check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		//print results
		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMemory location for theCoach " + theCoach);
		System.out.println("\nMemory location for alphaCoach" + alphaCoach);
		
		//close context
		context.close();
	}
}
