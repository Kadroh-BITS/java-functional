package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;




public class _Stream {

	public static void main(String[] args) {
		List<Person> people = List.of(
				new Person("John", Gender.MALE, 15),
				new Person("Maria", Gender.FEMALE, 20),
				new Person("Aysha", Gender.FEMALE, 22),
				new Person("Alex", Gender.MALE, 35),
				new Person("Alice", Gender.FEMALE, 19)			
				
				);
		
		//Prints set of all genders
		people.stream()
				.map(person->person.gender)
				.collect(Collectors.toSet())
				.forEach(System.out::println);
		
		//Prints set of all names
		people.stream()
				.map(person->person.name)
				.collect(Collectors.toSet())
				.forEach(System.out::println);
		
		//Prints length of names
		people.stream()
				.map(person->person.name)
				.mapToInt(name->name.length())
				.forEach(System.out::println);
		
		//Allmatch (FEMALE)
		boolean containsOnlyFemales = people.stream()
				.allMatch(person-> Gender.FEMALE.equals(person.gender));
		System.out.println(containsOnlyFemales);
		
		//AnyMatch (FEMALE)
		boolean containsOneOrMoreFemales = people.stream()
				.anyMatch(person-> Gender.FEMALE.equals(person.gender));
		System.out.println(containsOneOrMoreFemales);
				
		//NoneMatch (FEMALE)
		boolean doesNotContainPreferNotSay = people.stream()
				.noneMatch(person-> Gender.PREFER_NOT_SAY.equals(person.gender));
		System.out.println("doesNotContainPreferNotSay="+doesNotContainPreferNotSay);
		
		//NoneMatch name
		boolean doesNotContainName = people.stream()
				.noneMatch(person-> "Maria".equals(person.getName()));
		System.out.println("doesNotContainName= "+doesNotContainName);
		
		//Notice that these methods like - map, forEach, mapToInt, allMatch, anyMatch, noneMatch 
		//take Producer, Functions, Consumers or Suppliers as arguments
		
		//Filter (FEMALE)
		people.stream()
				.filter(p->Gender.FEMALE.equals(p.gender))
				.collect(Collectors.toList())
				.forEach(System.out::println);
		
		
		// Declarative Approach 2
		List<Person> females2 = people.stream()
				.filter(p->Gender.FEMALE.equals(p.gender))
				.collect(Collectors.toList());
		females2.forEach(System.out::println);
		
		//Sort according to names Ascending
		System.out.println("Sorted according to Names: Ascending");
		people.stream()
				.sorted(Comparator.comparing(Person::getName))
				.collect(Collectors.toList())
				.forEach(System.out::println);
		
		//Sort according to age Ascending
				System.out.println("Sorted according to Age: Ascending");
				people.stream()
						.sorted(Comparator.comparing(Person::getAge))
						.collect(Collectors.toList())
						.forEach(System.out::println);
		
		//Sort according to names Descending
		System.out.println("Sorted according to Names: Descending");
		people.stream()
				.sorted(Comparator.comparing(Person::getName).reversed())
				.collect(Collectors.toList())
				.forEach(System.out::println);
		
		//Max Value
		people.stream()
				.max(Comparator.comparing(Person::getName))
				.ifPresent(maxname -> System.out.println("Max Value is: "+ maxname.getName()));
		
		//Min Value
		people.stream()
			.min(Comparator.comparing(Person::getName))
			.ifPresent(minname -> System.out.println("Max Value is: "+ minname.getName()));
		
		//Group
		Map<Gender, List<Person>> groupByGender = people.stream()
				.collect(Collectors.groupingBy(Person::getGender));
		groupByGender.forEach((gender, people1) -> {
			System.out.println(gender);	
			people1.forEach(System.out::println);
		});
		
		
		//Find the oldest female and return the name
		people.stream()
				.filter(person->person.getGender().equals(Gender.FEMALE))
				.max(Comparator.comparing(Person::getAge))
				.ifPresent(oldestfemale -> System.out.println("Oldest Female is: "+ oldestfemale));
		
		//FInd oldest Male and print his name
		Optional<String> oldestMale = people.stream()
			.filter(person->person.getGender().equals(Gender.MALE))
			.max(Comparator.comparing(Person::getAge))
			.map(Person::getName);
			
		oldestMale.ifPresent(oldestmale -> System.out.println("Oldest Male's name is: "+ oldestmale));
				
	}
	static class Person{
		private final String name;
		private final Gender gender;
		private final Integer age;
		
		
		public Person(String name, Gender gender, Integer age) {
			super();
			this.name = name;
			this.gender = gender;
			this.age = age;
		}
		
		public String getName() {
			return name;
		}
		
		public Gender getGender() {
			return gender;
		}
		
		public Integer getAge() {
			return age;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + ", age=" + age + "]";
		}

			
	}
	
	enum Gender{
		MALE, FEMALE, PREFER_NOT_SAY;
	}

}
