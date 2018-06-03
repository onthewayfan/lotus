package com.lotus.designpatterns.factory;

public class AnimalFactory {
	
	
	public Animal getAnimal(String animalType) {
		if(animalType==null||animalType=="") {
			return null;
		}
		if(animalType.equalsIgnoreCase("SHEEP")) {
			return new Sheep();
		}else if(animalType.equalsIgnoreCase("DOG")) {
			return new Dog();
		}
		return null;
	}
	
	

}
