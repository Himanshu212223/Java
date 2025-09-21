

/* 
Exception Handling :-
_______________________________________________________________

Error in Java - 
-----------------------------------------------

1. Compile Time Error 
----------------------------
Compile-time errors occur when the program cannot compile due to syntax or type issues.
Example - missing Semicolon, Undeclared Variables, Mismatched dataTypes

2. Run Time Error 
----------------------------
Runtime errors occur when the program compiles but crashes or behaves unexpectedly.
Example - Division by Zero, Array Index Out of Bounds, Logical errors happen when the code runs, but the result is not what you thought.


Exception Handling (try and catch) - 
-----------------------------------------------
Exception handling lets you catch and handle errors during runtime - so your program doesn't crash.

try - The try statement allows you to define a block of code to be tested for errors while it is being executed.

catch - The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.

finally - The finally statement lets you execute code, after try...catch, regardless of the result.

throw - Throw keyword is used to explicitly throw an exception from a method or block of code.

*/

public class J_17_0_ExceptionalHandling {

	public static void main(String args[]) {

		int number = -1;

		try {
			if (number <= 0) {
				throw new Exception("Non-Positive Number not allowed");
			}
		} catch (Exception e) {
//			to get all the details of the exception : 
			System.out.println("The exception is " + e);
			System.out.println("Message is : " + e.getMessage());
			System.out.println("Cause is : " + e.getCause());
			System.out.print("Stack Trace is : ");
			e.getStackTrace();
			System.out.println("Suppressed is : " + e.getSuppressed());
			System.out.println("to string is : " + e.toString());
		}
		finally{
			System.out.println("Everything is working fine.");
		}

	}
}
