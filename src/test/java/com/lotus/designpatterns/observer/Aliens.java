package com.lotus.designpatterns.observer;

public class Aliens implements LandingObserver {

	@Override
	public void observerLanding(String name) {
		if(name.contains("Apollo")) {
			System.out.println("They're distracted ,lets invade earth!");
		}
	}

}
