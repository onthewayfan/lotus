package com.lotus.designpatterns.observer;

public class Nasa implements LandingObserver {

	@Override
	public void observerLanding(String name) {
		if(name.contains("Apollo")) {
			System.out.println("We made it!");
		}
	}

}
