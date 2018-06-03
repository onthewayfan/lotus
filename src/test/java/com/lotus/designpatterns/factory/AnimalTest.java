package com.lotus.designpatterns.factory;

public class AnimalTest {
	public static void main(String[] args) {
		AnimalFactory factory = new AnimalFactory();
		
		Animal animal1 = factory.getAnimal("SHEEP");
		
		animal1.eat();
		
		Animal animal2 = factory.getAnimal("dog");
		
		animal2.eat();
		
	}

}
