package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
	public static void main(String[] args) {
		int increment1 = increment(0);
		System.out.println(increment1);
		
		int increment2 = incrementByOneFunction.apply(1);
		System.out.println(increment2);
		
		int multiply = multiplyBy10Function.apply(increment2);
		System.out.println(multiply);
		
		
		int incrementAndMultipltBy10 = addBy1AndThenMultiplyBy10.apply(4);
		System.out.println(incrementAndMultipltBy10);
		
		int incrementNum1ByOneAndMultiplyByNum2 = incrementByOneAndMultiplyBiFunction.apply(9, 10);
		System.out.println(incrementNum1ByOneAndMultiplyByNum2);
		
		
	}
	
	
	// so following 2 functions are same 
	
	//Function 1 : Functional Style: First arg in <> is for input and second is for output
	static Function<Integer, Integer> incrementByOneFunction = n -> n+1;	
	
	//Function 2 : Traditional style
	static int increment(int number) {
		return number+1;
	}
	
	
	//Function 3: Multiply in functional style
	static Function<Integer, Integer> multiplyBy10Function = n -> n*10;
	
	
	//Function 4: Chaining multiple functions
	static Function<Integer, Integer> addBy1AndThenMultiplyBy10 = 
			incrementByOneFunction.andThen(multiplyBy10Function);
	
	
	//Function 5 and 6 do same work in different styles
	
	//Function 5: Traditional way
	static int incrementByOneAndMultiply(int number, int numberToMultiplyBy) {
		return (number+1)*numberToMultiplyBy;
	}
	
	//Function 6: Example of Bi-Function: There are 2 args for input and third arg for output in <> brackets
	//Thus Bi-Function takes 2 arguments and produces one output, where Function takes one argument and produces one output
	static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
			(numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne +1)*numberToMultiplyBy;
			
			

}
