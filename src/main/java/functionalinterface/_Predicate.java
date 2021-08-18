package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

	public static void main(String[] args) {
		System.out.println(isPhoneNumberValid("07000000000"));
		System.out.println(isPhoneNumberValid("0700000000"));
		System.out.println(isPhoneNumberValid("09009877300"));
		
		System.out.println("Using Predicate");		
		
		
		System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
		System.out.println(isPhoneNumberValidPredicate.test("0700000000"));
		
		System.out.println(isPhoneNumberValidPredicate.test("09000000000"));
		
		System.out.println("Contains Number 3? " + containsNumber3.test("992247044"));
		
		//combining two predicates(Fn 2 and fn 3) using and operator
		System.out.println("Is phone number valid and contains 3?: " + isPhoneNumberValidPredicate.and(containsNumber3).test("07009877300"));
		
		
		//combining two predicates(Fn 2 and fn 3) using or operator
		System.out.println("Is phone number valid and contains 3?: " + isPhoneNumberValidPredicate.or(containsNumber3).test("3"));
		
		System.out.println("Is phone number of specified length?: " + isPhoneNumberOfSpecifiedLength.test("1234567", 6));
	}
	
	//Function 1 and 2 do same task but in different styles
	
	//Functon 1: Traditional Way
	static boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("07") && phoneNumber.length() ==11;
	}
	
	//Function 2: Functional Way using predicate
	// A predicate accepts one input and outputs a Boolean Value
	static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
		phoneNumber.startsWith("07") && phoneNumber.length() ==11;
		
	//Function 3: Predicate to check whether number contains 3	
	static Predicate<String> containsNumber3 = phoneNumber ->
		phoneNumber.contains("3");
	
	
	//Function 4: Example of bi-predicate which accepts 2 inputs and returns boolean	
	static BiPredicate<String, Integer> isPhoneNumberOfSpecifiedLength = (number, length) ->
		number.length()==length;
		

}
