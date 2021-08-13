package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component//so springs scans and registers this class
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
