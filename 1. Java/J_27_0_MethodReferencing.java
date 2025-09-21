

/*
	Method Referencing:
	In this approach, if there is an interface and there is some other class which are not 
	implementing the interface but the methods present in the class are similar to that of 
	the interface, then, method referencing can be done.
	
*/

interface Operator{
	//	automatically becomes abstract method.
	public double calculate(double n1, double n2);
};



class Addition{
	public static double add(double n1, double n2) {
		System.out.println("we are adding.");
		return n1 + n2 ;
	}
	
	public double letsAdd(double n1, double n2) {
		System.out.println("Hii.. this is letsAdd") ;
		return n1 + n2 ;
	}
};




public class J_27_0_MethodReferencing {

	public static void main(String args[]) {

//		now, lets see how Method Referencing works.
//	the below line just establish a method referencing, and method calling is done in next line.
		
//	method referencing to static method
			Operator op1 = Addition::add ;
			System.out.print(op1.calculate(2, 3) );
		
			Addition a = new Addition();
			Operator op2 = a::letsAdd ;			//	non-static method referencing
			System.out.println(a.letsAdd(5, 9));
			System.out.println(op2.calculate(5, 9));
			
			
		}
}
