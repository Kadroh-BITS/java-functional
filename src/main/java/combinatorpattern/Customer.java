package combinatorpattern;

import java.time.LocalDate;

public class Customer {
	
	private final String name;
	private final String email;
	private final String phoneNumber;
	private final LocalDate dob;
	
	public Customer(String name, String email, String phoneNumber, LocalDate dob) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public LocalDate getDob() {
		return dob;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
