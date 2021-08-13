package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	//filename address
	private String fileName = "C:\\Users\\erikd\\eclipse-workspace\\spring-demo-annotations\\src\\fortunes-data";
	//fortunes string
	private List<String> theFortunes;
	
	//create random number generator
	Random myRandom = new Random();
	//file service method
	
	public FileFortuneService() {
		
		//set File
		File theFile = new File(this.fileName);
		
		//show file address and ifExists
		System.out.println("Reading fortunes file from: " + this.fileName);
		System.out.println("File exists: " + theFile.exists());
		
		//initialize arrayList
		theFortunes = new ArrayList<String>();
				
		//loop through file
		try(BufferedReader br = new BufferedReader(new FileReader(theFile))){
			//add fortunes
			String tempLine;
			
			while((tempLine = br.readLine()) != null) {
				System.out.println("\nLoading fortune: " + tempLine);
				theFortunes.add(tempLine);
				Thread.sleep(500);
			}
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFortune() {
		
		String tempFortune = theFortunes.get((myRandom.nextInt(theFortunes.size())));
	
		return tempFortune;
	}
}
	
	

	

