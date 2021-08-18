package optionals;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		Object value = Optional.ofNullable(null)
				.orElseGet(() ->"default value");
		
		Object value2 = Optional.ofNullable("String 1")
				.orElseGet(() ->"default value");
		
		
		System.out.println(value);
		System.out.println(value2);
		
		try {
			Object value3 = Optional.ofNullable(null)
					.orElseThrow(() ->new IllegalStateException("Illegal State Exception"));
			System.out.println(value3);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		Optional.ofNullable("Hello if Present")
				.ifPresent(v -> {
					System.out.println(v);
				});

		Optional.ofNullable(null)
				.ifPresent(v -> {
					System.out.println(v);
				});
		
		Optional.ofNullable("kadam@gmail.com")
				.ifPresent(email -> System.out.println("Sending email to "+ email));
		
		Optional.ofNullable(null)
				.ifPresentOrElse(
						email -> System.out.println("Sending email to "+ email), 
						() -> System.out.println("Cannot send email")
					);
		
		Optional.ofNullable("kadam@gmail.com")
				.ifPresentOrElse(
						email -> System.out.println("Sending email to "+ email), 
						() -> System.out.println("Cannot send email")
					);

	}

}
