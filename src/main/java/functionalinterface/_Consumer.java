package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

	public static void main(String[] args) {
		Customer maria = new Customer("Maria", "99999");
		greetCustomer(maria);
		greetCustomerConsumer.accept(maria);
		greetCustomerBiConsumer.accept(maria, false);
		greetCustomerBiConsumer.accept(maria, true);	
	}
	
	//function 1 : traditional way
	static void greetCustomer(Customer customer) {
		System.out.println("Hello" + customer.customerName + 
				", thanks for registering ph no. "+ customer.customerPhoneNumber);
	}
	
	
	//Function 2: Functional Way. Consumer is nothing but Function which consumes an input without returning anything.
	static Consumer<Customer> greetCustomerConsumer = customer ->
		System.out.println("Hello" + customer.customerName + 
				", thanks for registering ph no. "+ customer.customerPhoneNumber);
	
	//Function 3: This is a BiConsumer. It accepts two inputs and returns nothing. 
	// In this function, showPhoneNumber is second input which is boolean. 
	// If its true, only then the phone number will be printed else *** will be printed
	static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) ->
	System.out.println("Hello" + customer.customerName +  
			", thanks for registering ph no. "
			+(showPhoneNumber ? customer.customerPhoneNumber : "******"));
		
	static class Customer{
		private final String customerName;
		private final String customerPhoneNumber;
		public Customer(String customerName, String customerPhoneNumber) {
			
			this.customerName = customerName;
			this.customerPhoneNumber = customerPhoneNumber;
		}
		
		
		
	}

}
