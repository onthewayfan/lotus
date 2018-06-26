package com.lotus.designpatterns.observer;

public class ObserverTest {
	public static void main(String[] args) {
		
		  classConstruction();
		  
		  lambdaConstruction();
		
	}
	
	private static void classConstruction() {
		Moon moon = new Moon();
		moon.startSpying(new Nasa());
		moon.startSpying(new Aliens());
		moon.land("An asteroid");
		moon.land("Apollo 11");
	}
	
	private static void lambdaConstruction() {
		Moon moon = new Moon();
		
		moon.startSpying(name->{
			if(name.contains("Apollo")) {
				System.out.println("They're distracted ,lets invade earth!----");
			}
		});
		
		moon.startSpying(name->{
			if(name.contains("Apollo")) {
				System.out.println("We made it!----");
			}
		});

		
		moon.land("An asteroid");
		moon.land("Apollo 11");
		
	}
	
	

}
