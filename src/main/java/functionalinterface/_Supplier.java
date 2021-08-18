package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

	public static void main(String[] args) {
		System.out.println(getDBConnectionUrl());
		System.out.println(getDBConnectionUrlSupplier.get());
		System.out.println(getDBConnectionUrlListSupplier.get());

	}
	
	//Function 1- Traditional Way
	static String getDBConnectionUrl() {
		return "jdbc://localhost:5432/users";
	}
	
	//Function 2: Functional Way using Supplier interface. 
	// It is used to return values without consuming any input 
	// arg in <> is the return type
	static Supplier<String> getDBConnectionUrlSupplier = () ->
		"jdbc://localhost:5432/users";
		
	//Function 3: returns List<String>
	static Supplier<List<String>> getDBConnectionUrlListSupplier = () ->
		List.of("jdbc://localhost:5432/users", 
				"jdbc://localhost:5432/customers", 
				"jdbc://localhost:5432/producers");

}
