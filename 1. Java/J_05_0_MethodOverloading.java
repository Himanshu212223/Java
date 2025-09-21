

/*
	Method Overloading :-
	_______________________________________
	
	If 2 or more methods have same name but different signature or argument,
	and we are using these methods based on their arguments, then, it is called Method Overloading.

	- Which method is going to be called is defined at compile time, hence, it is also
		called as Compile time or Static Polymorphism.

	- Constructor can also be overloaded.
	
	- Java main method can be overloaded as well.
		1. But it will treate other main method as normal method.
		2. If we run the code, it will still call the actual main method which have String[] args
			or String args[] as a parameter.
		3. We can call other overloaded method on the actual main method just like any normal
			method.
									 
*/

public class J_05_0_MethodOverloading {
	
	public static void add(int numb1, int numb2) {
		int answer = numb1 + numb2 ;
		System.out.println("Answer is : " + answer) ;
	}

	public static void add(float numb1, float numb2) {
		float answer = numb1 + numb2 ;
		System.out.println("Answer is : " + answer) ;
	}
	
	public static void add(double numb1, double numb2) {
		double answer = numb1 + numb2 ;
		System.out.println("Answer is : " + answer) ;
	}
	
	public static void main(String args[]) {
		
		add(3, 4) ;
		add(3.5f, 4.7f) ;
		add(3.5, 4.7) ;
		
		main("sd");
		
		
	}
	
	//	Overloading Main Method as well.
	public static void main(int a) {
		System.out.println(a);

		// We can call this method on the actual main method like - main(34) ;
	}
	
	//	Overloading Main Method as well.
	public static void main(String a) {
		System.out.println(a);

		// We can call this method on the actual main method like - main("Woow") ;
	}
	
}
