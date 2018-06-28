package com.lotus.eclipse.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;

public class CollectionTest {
	
	public static void main(String[] args) {
		listTest();
	
		cListTest();
		
	}
	
	
	
	public static void listTest() {
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Alice", 19));
		people.add(new Person("Bob", 52));
		people.add(new Person("Carol", 35));
		
//		List.of(new Person("Alice", 19),
//				new Person("Bob", 52), new Person("Carol", 35)).stream();

		List<String> namesOver21 = people.stream()               // Bun
				       .filter(person -> person.getAge() > 21)  // Meat
				       .map(Person::getName)                    // Meat
				       .collect(Collectors.toList());           // Bun

				namesOver21.forEach(System.out::println);
	}
	
	
	
	public static void cListTest() {
		
		ImmutableList<Person> people = Lists.immutable.of(new Person("Alice", 19),
				new Person("Bob", 52), new Person("Carol", 35));

		ImmutableList<String> namesOver21 = people
				       .select(person -> person.getAge() > 21) // Meat, no buns
				       .collect(Person::getName);              // Meat

				namesOver21.forEach(System.out::println);
		
		
	}
	
	public static void gListTest() {
		
		
		
		
	}
	

}

class Person{
	String name;
	int age;
	
	Person(){}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	};
}
