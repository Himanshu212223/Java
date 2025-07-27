package learning;

/*
	Static :-
	_______________
	
	- Static variable or method defined in any class makes that member belongs to class, not to any object.

	- They can be used with or without object.
	
	- Static Block gets executed once the class get executed, even before constructor.
		This is only applicable when we are creating the object of that class.
	
	- Static variable or methods can be used directly through Class name if that member is not private.
	
	- Non-static variable cannot be used on static method.
	
	- Static variables can be used on non-static methods.
	
	These are the reason why the main method of Java is defined as Static.
	
	
	
	Final :-
	__________________
	
	- Final is similar to constant, and will never change.
	- Final method can be overloaded.
	- The final method will not get override as they are constants.
*/

class Foo{
	
	public static int flower ;
	
	static {
		System.out.println("I am static");
	}
	
	public void flowering() {
		flower+= 1;
	}
	
}


public class J_08_StaticAndFinal {
	
	
	public int number1 = 98 ;
	public static int number2 = 99 ;
	private static int number3 = 100 ;
	public final String className = "StaticKeyWord" ;
	
	
	
	public final void giveDetails() {
		//	The final method will not get override as they are constants.
		System.out.println("Numbers are : " + number1 + number2 + number3) ;
		System.out.println("Class is    : " + className) ;
	}
	
	
	
	
	
	
	public static void main(String args[]) {
		
	
//		System.out.println(number1);		//	This will throw error becz, cannot use non-static member without object.
			System.out.println(number2);			//	Static variable can be used directly.
			System.out.println(J_08_StaticAndFinal.number2) ;		//	Static can be used with class name.
			
			//	Lets make the object of class StaticKeyWord.
			J_08_StaticAndFinal skw = new J_08_StaticAndFinal() ;
			System.out.println(skw.number1);		//	This will not throw error.
			System.out.println(skw.number2);		//	This will work, but will show warning.
			
			
			skw.giveDetails();
			
		
			Foo jasmin = new Foo() ;
		
	}
}
