package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		List<Person> people = List.of(
				new Person("John", Gender.MALE),
				new Person("Maria", Gender.FEMALE),
				new Person("Aysha", Gender.FEMALE),
				new Person("Alex", Gender.MALE),
				new Person("Alice", Gender.FEMALE)			
				
				);
		
		System.out.println("Imperative approach");
		//Imperative approach
		
		List<Person> females = new ArrayList<>();
		for(Person person: people) {
			if(Gender.FEMALE.equals(person.gender)) {
				females.add(person);
			}
		}
		
		for(Person female: females) {
			System.out.println(female);
		}
		
		
		System.out.println("Declarative Approach 1");
		// Declarative Approach 1
		people.stream()
				.filter(p->Gender.FEMALE.equals(p.gender))
				.collect(Collectors.toList())
				.forEach(System.out::println);
		
		System.out.println("Declarative Approach 2");
		// Declarative Approach 2
		List<Person> females2 = people.stream()
				.filter(p->Gender.FEMALE.equals(p.gender))
				.collect(Collectors.toList());
		females2.forEach(System.out::println);
		
		//What is predicate? 
		//This statement is actually a predicate: p->Gender.FEMALE.equals(p.gender). It evaluates to boolean value.
		//It can be alternatively implemented as
		//Predicate<Person> personPredicate = p->Gender.FEMALE.equals(p.gender);
		//List<Person> females2 = people.stream()
				//.filter(personPredicate)
				//.collect(Collectors.toList());
		//females2.forEach(System.out::println);
		
		
	}

	
	static class Person{
		private final String name;
		private final Gender gender;
		
		public Person(String name, Gender gender) {
			super();
			this.name = name;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}
		
		
	}
	
	enum Gender{
		MALE, FEMALE;
	}
}
