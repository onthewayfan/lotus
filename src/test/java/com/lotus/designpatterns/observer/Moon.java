package com.lotus.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Moon {
	
	private final List<LandingObserver> observers = new ArrayList<>();
	
	public void land(String name) {
		for (LandingObserver observer : observers) {
			observer.observerLanding(name);
		}
	}
	
	public void startSpying(LandingObserver observer) {
		observers.add(observer);
	}
}
