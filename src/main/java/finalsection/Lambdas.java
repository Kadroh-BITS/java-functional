package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
	public static void main(String[] args) {
		System.out.println(upperCaseName.apply("string1"));
		
		try {
			System.out.println(validateAndupperCaseName.apply(""));
			
			System.out.println(ageValidateAndUpperCaseName.apply("string3", 13));
			
		} catch(Exception e){
			System.out.println(e.getMessage());			
		}

		
		
	}
	
	//Function 1
	static Function<String, String> upperCaseName = name -> name.toUpperCase();
	
	//Function 2
	static Function<String, String> validateAndupperCaseName = name-> {
		if(name.isBlank()) throw new IllegalArgumentException("Blank Name");
		return name.toUpperCase();
	};
	
	//Function 3: BiFunction
	static BiFunction<String, Integer, String> ageValidateAndUpperCaseName =  (name, age) -> {
		if(age<16) throw new IllegalArgumentException("Exceptioon: UnderAge");
		if(name.isBlank()) throw new IllegalArgumentException("Blank Name");
		return name.toUpperCase();
	};
	

}
