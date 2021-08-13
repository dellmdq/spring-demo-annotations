package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create an array of strings
	private String[] data = {
			"Beware of the wolf in sheep's clothing",
			 "Diligence is the mother of good luck",
			 "The journey is the reward"
	};
	
	@Override
	public String getFortune() {
		//create random number generator		
		Random myRandom = new Random ();
		//pick a random string from array
		return data[myRandom.nextInt(data.length)];
	}

	
}
