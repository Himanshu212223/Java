package learning;

/* 
Exception Handling :-
_________________________________

There are 2 ways to Handle Exceptions in methods .:
1. Handle the exception there itself.
2. Allow it to propogate to be handled somewhere else.


1. Handling the exception there itself .:
	We can use Try-Catch block for constructing an exception handler.
	If try block throws exception, then, catch block is used to catch and handle that exception.
	IF try does not throw any exception, then, catch block will get ignored.

like .:

	try{
		write the code here.
	}
	catch(Exception1 e1){
		to handle exception1 ;
	}
	catch(Exception2 e2){
		to handle exception2 ;
	}
	finally{
		write the rest important executable codes here.
	}
	
	
	Throw - 
	1. The throw keyword is used inside a function. 
		It is used when it is required to throw an Exception logically.
	2. The throw keyword is used to throw an exception explicitly. 
		It can throw only one exception at a time.
	
	Throws - 
	1. The throws keyword is used in the function signature. 
		It is used when the function has some statements that can lead to exceptions.
	2. The throws keyword can be used to declare multiple exceptions, separated by a comma. 
		Whichever exception occurs, if matched with the declared ones, is thrown automatically then.
*/

public class J_16_ExceptionalHandling {

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
