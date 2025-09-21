
/* 
Custom Exception Handling :-
_______________________________________________________________

- Custom error handling means creating your own exception classes 
to represent specific problems in your application.

- Instead of just using built-in exceptions (NullPointerException, IllegalArgumentException, etc.), 
 you can define custom exceptions to make your code more meaningful.

- Custom Exception must extend the Exception class.

throw and throws - 
--------------------------------------

throw - 
-----------------------
- throw is used to actually throw an exception object at runtime.



throws - 
-----------------------
- throws declares that a method may throw an exception, so caller must handle it.
	i.e., throws warns that throwing might happen.
- throws is usually mentioned at the method signature level.



*/


//	Define our Custom Exception - Custom Exception (must extend Exception or RuntimeException)

class InvalidAgeException extends Exception { 
	public InvalidAgeException(String message) { 
		super(message); 
	} 
}



public class J_18_0_CustomException {

	public static int addNumber (int a, int b ) throws InvalidAgeException {
		return a + b ;
	}

	public static void main(String args[]) {

		try {
			
			addNumber(45, 056) ;

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
