

/*
	Variable Argument Method :-
	______________________________________________
	
	Sometimes, we are not sure how many arguments we need to pass in the method.
	There comes the variable Argument Method.
	
	- The Variable Argument should be the last argument of the method.
	- The Variable argument acts as Array.
*/


public class J_06_0_VariableArgumentMethod {
	
	public static void printer(int a, int b, int ...argz) {
		System.out.println(a) ;
		System.out.println(b) ;
		
		for(int i : argz) {
			System.out.println(i);
		}
		
	}
	
	
	public static void main(String args[]) {
		
		printer(2, 5, 6, 8, 2, 0);
		
	}
}
