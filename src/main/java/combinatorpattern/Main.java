package combinatorpattern;

import java.time.LocalDate;

import combinatorpattern.CustomerRegistrationValidator.ValidationResult;

public class Main {

	public static void main(String[] args) {
		Customer customer = new Customer("Alice", "alice@gmail.com", 
								"+012335", LocalDate.of(2015, 1, 1));
		
		
		//Validation Using Traditional Way
		System.out.println(new CustomerValidationService().isValid(customer));
		
		
		System.out.println("Using Combinator Pattern");
		//Validation Using combinator Pattern
		ValidationResult result =  CustomerRegistrationValidator
			.isEmailValid()
			.and(CustomerRegistrationValidator.isPhoneNumberValid())
			.and(CustomerRegistrationValidator.isAnAdult())
			.apply(customer);
		
		System.out.println(result);
		if(result!= ValidationResult.SUCCESS) {
			throw new IllegalStateException(result.name());
		}

	}

}
